package com.makoware.framework.Assets.Loaders;

import com.badlogic.gdx.assets.AssetDescriptor;
import com.badlogic.gdx.assets.AssetLoaderParameters;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.assets.loaders.AsynchronousAssetLoader;
import com.badlogic.gdx.assets.loaders.FileHandleResolver;
import com.badlogic.gdx.assets.loaders.TextureLoader;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.NinePatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.Array;

/**
 * Created by Derek Arner on 3/16/15.
 */
public class NinePatchLoader extends AsynchronousAssetLoader<NinePatch, NinePatchLoader.NinePatchParameter> {

    private TextureLoader texLoader;

    public NinePatchLoader(FileHandleResolver resolver) {
        super(resolver);
        this.texLoader = new TextureLoader(resolver);
    }

    @Override
    public void loadAsync(AssetManager manager, String fileName, FileHandle file, NinePatchParameter parameter) {
        texLoader.loadAsync(manager,fileName, file, ((parameter==null) ? null : parameter.texParam));
    }

    @Override
    public NinePatch loadSync(AssetManager manager, String fileName, FileHandle file, NinePatchParameter parameter) {
        NinePatch patch = null;
        if(parameter!=null){
            Texture texture = texLoader.loadSync(manager, fileName, file, parameter.texParam);

            if(parameter.bounds != null) {
                patch = new NinePatch(texture, (int) parameter.bounds.x, (int) parameter.bounds.y, (int) parameter.bounds.width, (int) parameter.bounds.height);
            }
        }


        return patch;
    }

    @Override
    public Array<AssetDescriptor> getDependencies(String fileName, FileHandle file, NinePatchParameter parameter) {
        return texLoader.getDependencies(fileName, file, ((parameter==null) ? null : parameter.texParam) );
    }

    public static class NinePatchParameter extends AssetLoaderParameters<NinePatch> {
        public TextureLoader.TextureParameter texParam;
        public Rectangle bounds;

        public NinePatchParameter(Rectangle bounds){
            this(bounds, null);
        }

        public NinePatchParameter(Rectangle bounds, TextureLoader.TextureParameter texParam){
            this.bounds = bounds;
            this.texParam = texParam;
        }

        public NinePatchParameter(int left, int right, int top, int bottom){
            this(new Rectangle(left, right, top, bottom));
        }

        public NinePatchParameter(int left, int right, int top, int bottom, TextureLoader.TextureParameter texParam){
            this(new Rectangle(left, right, top, bottom), texParam);
        }
    }
}
