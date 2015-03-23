package com.makoware.demoproject.Game.Stuff;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.NinePatch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.makoware.framework.Assets.Loaders.NinePatchLoader;
import com.makoware.framework.Core.GameManager;
import com.makoware.framework.GUI.HUD.Overlay;
import com.makoware.framework.GUI.HUD.OverlayParam;
import com.makoware.framework.Input.Handlers.TouchInputHandler;
import com.makoware.framework.Input.Utils.Inputs;

public class PauseMenu extends Overlay implements TouchInputHandler {
	public static String tag = "PauseMenu";
//	private ArrayList<PauseMenuItem> menuItems;
	private int itemIndex = 0;
	
	public static float X = 0.3f;
	public static float W = 1.0f-(2*X);
	public static float Y = 0.25f;
	public static float H = 1.0f-(2*Y);

    private NinePatch border;
	private Sprite arrowUp;
	private Sprite arrowDown;
	private Sprite go;

    private AssetManager am;

    private Sprite horse;

	public PauseMenu(){
        super(true);
        this.am = GameManager.getAssetManager();
//		menuItems = new ArrayList<PauseMenuItem>();

//		arrowUp = new Sprite(AssetManager.get("arrow"));
//		arrowUp.setBounds(0, 0, 150, 150);
//		arrowUp.setOrigin(75, 75);
//		arrowUp.setRotation(90);
//		arrowDown = new Sprite(arrowUp);
//		arrowDown.setRotation(270);
//		go = new Sprite(AssetManager.get("star"));
//		go.setBounds(0, 0, 150, 150);
//		go.setOrigin(75, 75);

        am.load("data/images/border.png", NinePatch.class, new NinePatchLoader.NinePatchParameter(5,5,5,5));

    }
	
	@Override
	public boolean shouldPause() {
		return true;
	}

	@Override
	public void draw(Rectangle frame, SpriteBatch batch, float deltaTime){
//		HUD.begin(batch);

        float width = Gdx.graphics.getWidth();
        float height = Gdx.graphics.getHeight();

        this.border.draw(batch, X*width, Y*height, W*width, H*height);
		this.horse.draw(batch);
//		for(PauseMenuItem i : menuItems){
//			i.draw(batch);
//		}
		
//		Gdx.app.log(tag, "w="+Gdx.graphics.getWidth()+" h="+Gdx.graphics.getHeight());
//		HUD.border.draw(batch, 0.5f*Gdx.graphics.getWidth(), 0.5f*Gdx.graphics.getHeight(), 0.5f*Gdx.graphics.getWidth(), 0.5f*Gdx.graphics.getHeight());
		
//		HUD.end(batch);
	}

	@Override
	public void up(Inputs.KeyDirection dir) {
//		if(dir==0){
//			menuItems.get(itemIndex ).deactivate();
//			this.itemIndex--;
//			if(this.itemIndex<0)
//				this.itemIndex++;
//			menuItems.get(itemIndex).activate();
//		}
	}

	@Override
	public void down(Inputs.KeyDirection dir) {
//		if(dir==0){
//			menuItems.get(itemIndex ).deactivate();
//			this.itemIndex++;
//			if(this.itemIndex>=menuItems.size())
//				this.itemIndex--;
//			menuItems.get(itemIndex).activate();
//		}
	}

    @Override
    public void left(Inputs.KeyDirection dir) {

    }

    @Override
    public void right(Inputs.KeyDirection dir) {

    }

    @Override
    public void LAxis(Inputs axis, float val) {

    }

    @Override
    public void L1(Inputs.KeyDirection dir) {

    }

    @Override
    public void L2(Inputs.KeyDirection dir) {

    }

    @Override
    public void L3(Inputs.KeyDirection dir) {

    }

    @Override
    public void RAxis(Inputs axis, float val) {

    }

    @Override
    public void R1(Inputs.KeyDirection dir) {

    }

    @Override
    public void R2(Inputs.KeyDirection dir) {

    }

    @Override
    public void R3(Inputs.KeyDirection dir) {

    }

    @Override
    public void triangle(Inputs.KeyDirection dir) {

    }

    @Override
	public void circle(Inputs.KeyDirection dir) {
		menu(dir);
	}

	@Override
	public void cross(Inputs.KeyDirection dir) {
//		if(dir==1)
//			menuItems.get(itemIndex).action();
	}

	@Override
	public void square(Inputs.KeyDirection dir) {
	}

	@Override
	public void start(Inputs.KeyDirection dir) {
		menu(dir);
	}

	@Override
	public void select(Inputs.KeyDirection dir) {
		menu(dir);
	}

	@Override
	public void menu(Inputs.KeyDirection dir) {
		if(dir== Inputs.KeyDirection.DOWN){
			hide();
		}
	}
	
	@Override
	public void touchDown(int screenX, int screenY, int pointer, int button) {
//		Vector3 v = new Vector3(screenX,screenY,0);
//		HUD.hudCam.unproject(v);
//		if(arrowUp.getBoundingRectangle().contains(v.x, v.y)){
//			up(0);
//			arrowUp.setColor(Color.RED);
//		}
//		if(arrowDown.getBoundingRectangle().contains(v.x, v.y)){
//			down(0);
//		}
//		if(go.getBoundingRectangle().contains(v.x, v.y)){
//			cross(0);
//		}
	}
	
	@Override
	public void touchUp(int screenX, int screenY, int pointer, int button) {
//		if(screenX)
//		Vector3 v = new Vector3(screenX,screenY,0);
//		HUD.hudCam.unproject(v);
//		if(arrowUp.getBoundingRectangle().contains(v.x, v.y)){
//			up(1);
//			arrowUp.setColor(Color.WHITE);
//		}
//		if(arrowDown.getBoundingRectangle().contains(v.x, v.y)){
//			down(1);
//		}
//		if(go.getBoundingRectangle().contains(v.x, v.y)){
//			cross(1);
//		}
	}
	
	@Override
	public void touchDragged(int screenX, int screenY, int pointer) {
	}
	
	@Override
	public void onHide() {
//		params.get("unpause", Callback.class).call(null);
//		menuItems.clear();
	}
	
	@Override
	public void onShow(OverlayParam p) {
		int index = 0;
		itemIndex = 0;

        this.border = GameManager.getAssetManager().get("data/images/border.png", NinePatch.class);
        this.horse = new Sprite(GameManager.getAssetManager().get("data/images/toyzrockinghorse.png", Texture.class));
        this.horse.setBounds(40,40,20,20);
//		menuItems.add(new PauseMenuItem(index++,"Resume",new Callback() {
//
//			@Override
//			public void call(Message m) {
////					Gdx.app.log(tag, "resume from menu");
//				PauseMenu.this.hide();
//			}
//		}));
//
//
//		menuItems.add(new PauseMenuItem(index++,"Restart",new Callback() {
//
//			@Override
//			public void call(Message m) {
//				Gdx.app.log(tag, "restart from menu");
////				PauseMenu.this.params.get("restart", Callback.class).call(null);
//			}
//		}));
//
//		menuItems.add(new PauseMenuItem(index++,"Quit",new Callback(){
//
//			@Override
//			public void call(Message m) {
//				Gdx.app.exit();
//			}
//
//		}));
	}

	@Override
	public boolean needsToDraw() {
//		return ESgame.type==AppType.Android;
		return false;
	}

	@Override
	public void drawService(SpriteBatch batch) {
		
//		arrowUp.setPosition(0.1f*HUD.width, (0.5f*HUD.height)+3); //(0.5f*HUD.height)+3
//		arrowUp.draw(batch);
//		arrowDown.setPosition(0.1f*HUD.width, (0.5f*HUD.height)-(arrowDown.getHeight()+3));
//		arrowDown.draw(batch);
//
//		go.setPosition( (0.9f*HUD.width)-(go.getWidth()), (0.5f*HUD.height)-(0.5f*go.getHeight()));
//		go.draw(batch);
	}

}
