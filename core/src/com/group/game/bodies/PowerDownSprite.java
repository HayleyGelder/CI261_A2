package com.group.game.bodies;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.group.game.utility.BonusManager;
import com.group.game.utility.TweenData;
import com.group.game.utility.UniversalResource;

import aurelienribon.tweenengine.BaseTween;
import aurelienribon.tweenengine.TweenCallback;
import aurelienribon.tweenengine.TweenManager;

public class PowerDownSprite extends AnimatedSprite implements IPowerUpSprite {
    private TweenData tweenData;
    private TweenManager tweenManager;
    private TweenCallback callback;
    private float animationTime;
    private int ttl;
    private float timeCount;
    private boolean displayed = false;

    public boolean isDisplayed() {return displayed;}

    @Override
    public void draw(SpriteBatch sb) {
        this.draw(sb);
    }

    public PowerDownSprite(String atlasString, Texture t, Vector2 pos) {
        super(atlasString, t, pos);
        // Alpha set a 0 means the sprite cannot be seen
        this.setAlpha(0);
        ttl = setTimeToLive(0);
        callback = new TweenCallback() {
            @Override
            public void onEvent(int type, BaseTween<?> source) {
                setDisplayed(false);
                initTweenData();
                BonusManager.handlingCollision = false;
            }
        };
        initTweenData();
    }

    private void initTweenData() {
        tweenData = new TweenData();
        tweenData.setXy(new Vector2 (this.getX(), this.getY()));
        tweenData.setColor(this.getColor());
        tweenData.setScale(this.getScaleX());
        tweenManager = UniversalResource.getInstance().tweenManager; //tweenManager
    }

    private int setTimeToLive(int t) {
        ttl = t;
        return ttl;
    }

    public void setDisplayed(boolean d) {
        displayed = d;
    }

    public void startRoutine() {

    }

    public void destroyRoutine() {

    }
}

