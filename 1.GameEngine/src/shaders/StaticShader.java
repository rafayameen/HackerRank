package shaders;

import org.lwjgl.util.vector.Matrix4f;

import entities.Camera;
import entities.Light;
import textures.ModelTexture;
import toolbox.Maths;

public class StaticShader extends ShaderProgram
{
	private static final String VERT_FILE = "src/shaders/vertexShader.txt";
	private static final String FRAG_FILE = "src/shaders/fragmentShader.txt";
	
	private int location_transformationMatrix;
	private int location_projectionMatrix;
	private int location_viewMatrix;
	private int location_lightPosition;
	private int location_lightColour;
	private int location_shineDamper;
	private int location_reflectivity;
	
	public StaticShader() {
		super(VERT_FILE, FRAG_FILE);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void bindAttributes() {
		// TODO Auto-generated method stub
		bindAttrib(0, "position");
		bindAttrib(1, "textureCoords");		
		bindAttrib(2, "normal");
	}

	@Override
	protected void getAllUniformLocations()
	{
		// TODO Auto-generated method stub
		location_transformationMatrix = super.getUniformLocation("transformationMatrix");
		location_projectionMatrix = super.getUniformLocation("projectionMatrix");
		location_viewMatrix = super.getUniformLocation("viewMatrix");
		location_lightPosition = super.getUniformLocation("lightPosition");
		location_lightColour = super.getUniformLocation("lightColour");
		location_shineDamper = super.getUniformLocation("shineDamper");
		location_reflectivity = super.getUniformLocation("reflectivity");
	}
	
	public void loadTransformationMatrix(Matrix4f transformation)
	{
		super.loadMatrix(location_transformationMatrix, transformation);
	}
	
	public void loadLight(Light light)
	{
		super.loadVector(location_lightPosition, light.getPosition());
		super.loadVector(location_lightColour, light.getColor());
	}
	
	public void loadViewMatrix(Camera camera)
	{
		Matrix4f viewMatrix = Maths.createViewMatrix(camera);
		super.loadMatrix(location_viewMatrix, viewMatrix);
	}
	
	public void loadProjectionMatrix(Matrix4f projection)
	{
		super.loadMatrix(location_projectionMatrix, projection);
	}
	
	public void loadSpecularVariables(ModelTexture texture)
	{
		super.loadFloat(location_shineDamper, texture.getShineDamper());
		super.loadFloat(location_reflectivity, texture.getReflectivity());
	}
	
	

}
