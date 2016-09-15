package renderEngine;

import java.util.List;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.util.ArrayList;

import org.lwjgl.BufferUtils;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL15;
import org.lwjgl.opengl.GL20;
import org.lwjgl.opengl.GL30;
import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.TextureLoader;

import models.RawModel;

public class Loader 
{
	//lists to store created vaos and vbos
	private List<Integer> vaos = new ArrayList<Integer>();
	private List<Integer> vbos = new ArrayList<Integer>();
	private List<Integer> textures = new ArrayList<Integer>();
	
	public RawModel loadToVAO(float[] positions,float[] textureCoords,float[] normals, int[] indices)
	{
		int vaoID = createVAO();
		storeDataInAttribList(0, 3, positions);
		storeDataInAttribList(1, 2, textureCoords);
		storeDataInAttribList(2, 3, normals);
		bindIndicesBuffer(indices);
		unbindVAO();
		//every vertex has three axis so divide the length by 3 to get vertex
		return new RawModel(vaoID, indices.length);
	}
	
	public int loadTexture(String fileName)
	{
		Texture texture = null;
		try {
			texture = TextureLoader.getTexture("PNG", new FileInputStream("res/" + fileName + ".png"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		int textureID = texture.getTextureID();
		textures.add(textureID);
		GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_MAG_FILTER, GL11.GL_LINEAR);
		GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_MIN_FILTER, GL11.GL_LINEAR);
		GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_WRAP_S, GL11.GL_REPEAT);
		GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_WRAP_T, GL11.GL_REPEAT);
		return textureID;
	}
	
	public int createVAO()
	{
		int vaoID = GL30.glGenVertexArrays();	
		vaos.add(vaoID);
		GL30.glBindVertexArray(vaoID);
		
		return vaoID;
	}
	
	//method to create vbo and store in vao at specific index
	public void storeDataInAttribList(int vaoIndex,int coordinatesSize, float[] data)
	{
		//create vbo
		int vboID = GL15.glGenBuffers();
		vbos.add(vboID);
		//bind vbo
		GL15.glBindBuffer(GL15.GL_ARRAY_BUFFER,	vboID);
		//create buffer
		FloatBuffer buffer = storeDataInFloatBuffer(data);
		//get data in vbo
		GL15.glBufferData(GL15.GL_ARRAY_BUFFER, buffer, GL15.GL_STATIC_DRAW);
		//store vbo in vao
		GL20.glVertexAttribPointer(vaoIndex, coordinatesSize, GL11.GL_FLOAT, false, 0, 0);
		
		//unbind vbo after use
		GL15.glBindBuffer(GL15.GL_ARRAY_BUFFER, 0);
		
	}
	
	public void bindIndicesBuffer(int[] indices)
	{
		//indices belong to model so store in vbo
		int vboID = GL15.glGenBuffers();
		vbos.add(vboID);
		GL15.glBindBuffer(GL15.GL_ELEMENT_ARRAY_BUFFER, vboID);
		IntBuffer buffer = storeDataInIntBuffer(indices);
		GL15.glBufferData(GL15.GL_ELEMENT_ARRAY_BUFFER, buffer, GL15.GL_STATIC_DRAW);
	}
	
	public void cleanUp()
	{
		for(int vao: vaos)
		{
			GL30.glDeleteVertexArrays(vao);
		}
		
		for(int vbo: vbos)
		{
			GL15.glDeleteBuffers(vbo);
		}
		
		for(int texture: textures)
		{
			GL11.glDeleteTextures(texture);
		}
	}
	
	public void unbindVAO()
	{
		GL30.glBindVertexArray(0);
	}
	
	public IntBuffer storeDataInIntBuffer(int[] data)
	{
		IntBuffer buffer = BufferUtils.createIntBuffer(data.length);
		buffer.put(data);
		buffer.flip();
		
		return buffer;
		
	}
	
	public FloatBuffer storeDataInFloatBuffer(float[] data)
	{
		FloatBuffer buffer = BufferUtils.createFloatBuffer(data.length);
		buffer.put(data);
		buffer.flip();
		
		return buffer;
		
	}

}
