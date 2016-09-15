package textures;

public class ModelTexture 
{
	private int textureID;
	
	private float shineDamper = 1;		//how far is camera from reflected light
	private float reflectivity = 0;		//intensity of reflected light

	public float getShineDamper()
	{
		return shineDamper;
	}

	public void setShineDamper(float shineDamper)
	{
		this.shineDamper = shineDamper;
	}

	public float getReflectivity()
	{
		return reflectivity;
	}

	public void setReflectivity(float reflectivity)
	{
		this.reflectivity = reflectivity;
	}

	public ModelTexture(int textureID) {
		super();
		this.textureID = textureID;
	}

	public int getTextureID() {
		return textureID;
	}
	
	

}
