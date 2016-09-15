package renderEngine;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;

import org.lwjgl.util.vector.Vector2f;
import org.lwjgl.util.vector.Vector3f;

import models.RawModel;

public class ObjLoader
{
	 static ArrayList<Integer> vertexData = new ArrayList<Integer>();
	public static RawModel loadObjModel(String fileName, Loader loader)
	{
		FileReader fr = null;
		try
		{
			fr = new FileReader(new File("res/" + fileName + ".obj"));
		} catch (FileNotFoundException e)
		{
			System.err.println("Unable to load file!");
			e.printStackTrace();
		}

		BufferedReader reader = new BufferedReader(fr);
		String line;
		ArrayList<Vector3f> verticesArray = new ArrayList<Vector3f>();
		ArrayList<Vector2f> textureCoordsArray = new ArrayList<Vector2f>();
		ArrayList<Vector3f> normalsArray = new ArrayList<Vector3f>();
		ArrayList<Integer> indicesArray = new ArrayList<Integer>();

		// arrays for loader
		float[] vertices = null;
		float[] textureCoords = null;
		float[] normals = null;
		int[] indices = null;

		try
		{
			// infinite loop to break manually after doing data calculations
			while (true)
			{
				line = reader.readLine();
				String[] currentLine = line.split(" ");

				if(line.startsWith("v "))
				{
					// vertices
					Vector3f vertex = new Vector3f(Float.parseFloat(currentLine[1]), Float.parseFloat(currentLine[2]),
							Float.parseFloat(currentLine[3]));
					verticesArray.add(vertex);
				} else if(line.startsWith("vt "))
				{
					// textureCoords
					Vector2f texture = new Vector2f(Float.parseFloat(currentLine[1]), Float.parseFloat(currentLine[2]));
					textureCoordsArray.add(texture);
				} else if(line.startsWith("vn "))
				{
					// normals
					Vector3f normal = new Vector3f(Float.parseFloat(currentLine[1]), Float.parseFloat(currentLine[2]),
							Float.parseFloat(currentLine[3]));
					normalsArray.add(normal);
				} else if(line.startsWith("f "))
				{
					// indices
					// loaded all the data now needs to store in arrays for
					// loader
					// each textureCoordinate has two vertices so if 4
					// coordinates array of 4 * 2
					textureCoords = new float[verticesArray.size() * 2];
					// similarly for normals
					normals = new float[verticesArray.size() * 3];
					break;
				}

			}

			while (line != null)
			{
				// read faces lines again
				// skip if not starting with f
				if(!line.startsWith("f"))
				{
					line = reader.readLine();
					continue;
				}

				// break the line into three parts for each vertex
				String[] currentLine = line.split(" ");

				// vertex joining data
				String[] vertex1 = currentLine[1].split("/");	//indices
				String[] vertex2 = currentLine[2].split("/");	//tcs
				String[] vertex3 = currentLine[3].split("/");	//normals
				
				//printVertexData(vertex1[0]);
				
				processVertex(vertex1, indicesArray, textureCoordsArray,normalsArray, textureCoords, normals);
				processVertex(vertex2, indicesArray, textureCoordsArray,normalsArray, textureCoords, normals);
				processVertex(vertex3, indicesArray, textureCoordsArray,normalsArray, textureCoords, normals);
				line = reader.readLine();
			}
			
			reader.close();
			
			

		} catch (Exception e)
		{
			e.printStackTrace();
		}
		
		vertices = new float[verticesArray.size() * 3];
		indices = new int[indicesArray.size()];
		
		int vertexPointer = 0;
		for(Vector3f vertex: verticesArray)
		{
			vertices[vertexPointer] = vertex.x;
			vertexPointer++;
			vertices[vertexPointer++] = vertex.y;
			vertices[vertexPointer++] = vertex.z;
			
		}
		
		for(int i = 0; i < indicesArray.size(); i++)
		{
			indices[i] = indicesArray.get(i);
		}
		
		return loader.loadToVAO(vertices, textureCoords,normals, indices);

	}

	// process vertex joining data
	private static void processVertex(String[] vertex, ArrayList<Integer> indicesArray,
			ArrayList<Vector2f> textureCoordsArray, ArrayList<Vector3f> normalArray,
			float[] textures, float[] normals)
	{
		//indices
		int currentVertexPointer = Integer.parseInt(vertex[0])-1;	//position of vertices
		//System.out.println("vertexPointer : "+ currentVertexPointer);
		indicesArray.add(currentVertexPointer);	//v index 
		//textures
		Vector2f currentTex = textureCoordsArray.get(Integer.parseInt(vertex[1]) - 1);	//vt
		textures[currentVertexPointer * 2] =   currentTex.x;
		textures[currentVertexPointer * 2+1] = currentTex.y;
		//normals
		Vector3f currentNorm = normalArray.get(Integer.parseInt(vertex[2]) - 1);
		normals[currentVertexPointer * 3] = currentNorm.x;
		normals[currentVertexPointer * 3+1] = 1 - currentNorm.y;
		normals[currentVertexPointer * 3+2] = currentNorm.z;
	

	}
	
	public static void printVertexData(String vertex1)
	{
		System.out.println(vertex1 + " ");
	}

}
