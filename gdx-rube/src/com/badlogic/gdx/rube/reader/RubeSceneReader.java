package com.badlogic.gdx.rube.reader;

import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.rube.RubeScene;
import com.badlogic.gdx.rube.reader.serializer.RubeSceneSerializer;
import com.badlogic.gdx.utils.Json;
import com.badlogic.gdx.utils.SerializationException;

/**
 * Loader for Rube json files. Gives you a populated {@link RubeScene}.
 * @author clement.vayer
 */
public class RubeSceneReader<T extends RubeScene>
{
	/**Used to parse the Json files*/
	private final Json json;
	private final RubeSceneSerializer<T> sceneSerializer;

    // for generics
    private final Class<T> cls;
	
	public RubeSceneReader(Class<T> cls) {
        this.cls = cls;
		json = new Json();
		json.setTypeName(null);
		json.setUsePrototypes(false);
		json.setIgnoreUnknownFields(true);
		
		sceneSerializer =  new RubeSceneSerializer<T>(cls,json);
		
		json.setSerializer(cls, sceneSerializer);
	}
	
	/**
	 * 
	 * @param file File to read.
	 * @return the scene described in the document.
	 */
	public T readScene(FileHandle file) {
		return readScene(file, false);
	}
	
	/**
	 * 
	 * @param file File to read.
	 * @param stripImageFile True if you want the filepath in the RubeImages to be stripped from path and extension. Useful when using a TextureAtlas
	 * @return the scene described in the document.
	 */
	public T readScene(FileHandle file, boolean stripImageFile) {
		T scene = null;
		try 
		{
			sceneSerializer.stripImageFile = stripImageFile;
			scene = json.fromJson(cls, file);
		} 
		catch (SerializationException ex) 
		{
			throw new SerializationException("Error reading file: " + file, ex);
		}
		return scene;
	}
}
