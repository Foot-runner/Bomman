package uet.thainguyen.game.controllers;

import com.badlogic.gdx.Files;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Animation.PlayMode;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;

public class AnimationController {

    private static final String WALKING_UP_KEY = "walking_up";
    private static final String WALKING_DOWN_KEY = "walking_down";
    private static final String WALKING_RIGHT_KEY = "walking_right";
    private static final String WALKING_LEFT_KEY = "walking_left";
    private static final String IDLING_UP_KEY = "idling_up";
    private static final String IDLING_DOWN_KEY = "idling_down";
    private static final String IDLING_RIGHT_KEY = "idling_right";
    private static final String IDLING_LEFT_KEY = "idling_left";
    private static final String DYING_KEY = "dying";
    private static final String CENTER_KEY = "center";
    private static final String VERTICAL_KEY = "vertical";
    private static final String HORIZONTAL_KEY = "horizontal";
    private static final String ITEM_BACKGROUND_KEY = "background";
    private static final String ITEM_IMAGE_KEY = "image";
    private static final String SPEED_ITEM_KEY = "speed_item";
    private static final String SUPER_BOMB_ITEM_KEY = "super_bomb_item";
    private static final String BOMB_SPACE_ITEM_KEY = "bomb_bag_item";
    private static final String SLOW_ITEM_KEY = "slow_item";
    private static final String LIFE_ITEM_KEY = "life_item";

    private static final int PLAYER_FRAME_COLS = 4;
    private static final int PLAYER_FRAME_ROWS = 6;
    private static final float PLAYER_FRAME_DURATION = 0.15f;

    private static final int HARE_FRAME_COLS = 9;
    private static final int HARE_FRAME_ROWS = 4;
    private static final float HARE_FRAME_DURATION = 0.1f;

    private static final int OCTOPUS_FRAME_COLS = 16;
    private static final int OCTOPUS_FRAME_ROWS = 1;
    private static final float OCTOPUS_FRAME_DURATION = 0.1f;

    private static final int BOMB_FRAME_COLS = 3;
    private static final int BOMB_FRAME_ROWS = 5;
    private static final float BOMB_FRAME_DURATION = 0.2f;

    private static final int FLAME_FRAME_COLS = 4;
    private static final int FLAME_FRAME_ROWS = 8;
    private static final float FLAME_FRAME_DURATION = 0.1f;

    private static final int ITEM_FRAME_COLS = 8;
    private static final int ITEM_FRAME_ROWS = 16;
    private static final float ITEM_FRAME_DURATION = 0.1f;

    public static void loadPlayerAnimation(HashMap<String, Animation<TextureRegion>> playerAnimations) {

        Texture playerTexture = new Texture(Gdx.files.internal("sprites/bomberman1.png"));
        TextureRegion[][] playerSprites = TextureRegion.split(playerTexture,
                playerTexture.getWidth() / PLAYER_FRAME_COLS,
                playerTexture.getHeight() / PLAYER_FRAME_ROWS);

        TextureRegion[] walkingLeftFrames = new TextureRegion[3];
        TextureRegion[] walkingRightFrames = new TextureRegion[3];
        TextureRegion[] walkingUpFrames = new TextureRegion[3];
        TextureRegion[] walkingDownFrames = new TextureRegion[3];
        TextureRegion[] dyingFrames = new TextureRegion[3];

        for (int i = 0; i < 3; i++) {
            walkingLeftFrames[i] = playerSprites[0][i];
            walkingRightFrames[i] = playerSprites[1][i];
            walkingUpFrames[i] = playerSprites[2][i];
            walkingDownFrames[i] = playerSprites[3][i];
            dyingFrames[i] = playerSprites[5][i];
        }

        Animation<TextureRegion> walkingLeftAnimation = new Animation<>(PLAYER_FRAME_DURATION, walkingLeftFrames);
        walkingLeftAnimation.setPlayMode(PlayMode.LOOP_REVERSED);

        Animation<TextureRegion> walkingRightAnimation = new Animation<>(PLAYER_FRAME_DURATION, walkingRightFrames);
        walkingRightAnimation.setPlayMode(PlayMode.LOOP_REVERSED);

        Animation<TextureRegion> walkingUpAnimation = new Animation<>(PLAYER_FRAME_DURATION, walkingUpFrames);
        walkingUpAnimation.setPlayMode(PlayMode.LOOP);

        Animation<TextureRegion> walkingDownAnimation = new Animation<>(PLAYER_FRAME_DURATION, walkingDownFrames);
        walkingDownAnimation.setPlayMode(PlayMode.LOOP);

        Animation<TextureRegion> dyingAnimation = new Animation<>(PLAYER_FRAME_DURATION, dyingFrames);
        dyingAnimation.setPlayMode(PlayMode.NORMAL);

        Animation<TextureRegion> idlingUpAnimation = new Animation<>(PLAYER_FRAME_DURATION, walkingUpFrames[0]);
        Animation<TextureRegion> idlingDownAnimation = new Animation<>(PLAYER_FRAME_DURATION, walkingDownFrames[0]);
        Animation<TextureRegion> idlingRightAnimation = new Animation<>(PLAYER_FRAME_DURATION, walkingRightFrames[0]);
        Animation<TextureRegion> idlingLeftAnimation = new Animation<>(PLAYER_FRAME_DURATION, walkingLeftFrames[0]);

        playerAnimations.put(WALKING_LEFT_KEY, walkingLeftAnimation);
        playerAnimations.put(WALKING_RIGHT_KEY, walkingRightAnimation);
        playerAnimations.put(WALKING_UP_KEY, walkingUpAnimation);
        playerAnimations.put(WALKING_DOWN_KEY, walkingDownAnimation);
        playerAnimations.put(IDLING_LEFT_KEY, idlingLeftAnimation);
        playerAnimations.put(IDLING_RIGHT_KEY, idlingRightAnimation);
        playerAnimations.put(IDLING_UP_KEY, idlingUpAnimation);
        playerAnimations.put(IDLING_DOWN_KEY, idlingDownAnimation);
        playerAnimations.put(DYING_KEY, dyingAnimation);
    }

    public static void loadHareAnimations(HashMap<String, Animation<TextureRegion>> hareAnimations) {
        Texture hareTexture = new Texture(Gdx.files.internal("sprites/enemies/Hare.png"));
        TextureRegion[][] hareSprites = TextureRegion.split(hareTexture,
                hareTexture.getWidth() / HARE_FRAME_COLS,
                hareTexture.getHeight() / HARE_FRAME_ROWS);

        TextureRegion[] walkingLeftFrames = new TextureRegion[7];
        TextureRegion[] walkingRightFrames = new TextureRegion[7];
        TextureRegion[] walkingUpFrames = new TextureRegion[9];
        TextureRegion[] walkingDownFrames = new TextureRegion[9];

        for (int i = 0; i < 9; i++) {
            walkingDownFrames[i] = hareSprites[0][i];
            walkingUpFrames[i] = hareSprites[1][i];
        }
        for (int i = 0; i < 7; i++) {
            walkingLeftFrames[i] = hareSprites[2][i];
        }
        for (int i = 2,j = 0; i < 9; i++, j++) {
            walkingRightFrames[j] = hareSprites[3][i];
        }

        Animation<TextureRegion> walkingLeftAnimation = new Animation<>(HARE_FRAME_DURATION, walkingLeftFrames);
        walkingLeftAnimation.setPlayMode(PlayMode.LOOP);

        Animation<TextureRegion> walkingRightAnimation = new Animation<>(HARE_FRAME_DURATION, walkingRightFrames);
        walkingRightAnimation.setPlayMode(PlayMode.LOOP);

        Animation<TextureRegion> walkingUpAnimation = new Animation<>(HARE_FRAME_DURATION, walkingUpFrames);
        walkingUpAnimation.setPlayMode(PlayMode.LOOP);

        Animation<TextureRegion> walkingDownAnimation = new Animation<>(HARE_FRAME_DURATION, walkingDownFrames);
        walkingDownAnimation.setPlayMode(PlayMode.LOOP);

        hareAnimations.put(WALKING_LEFT_KEY, walkingLeftAnimation);
        hareAnimations.put(WALKING_RIGHT_KEY, walkingRightAnimation);
        hareAnimations.put(WALKING_UP_KEY, walkingUpAnimation);
        hareAnimations.put(WALKING_DOWN_KEY, walkingDownAnimation);
    }

    public static void loadOctopusAnimations(HashMap<String, Animation<TextureRegion>> octopusAnimations) {
        Texture octopusTexture = new Texture(Gdx.files.internal("sprites/enemies/Octopus.png"));
        Texture octopusFlippedTexture = new Texture(Gdx.files.internal("sprites/enemies/Octopus_flipped.png"));
        TextureRegion[][] octopusSprites = TextureRegion.split(octopusTexture,
                octopusTexture.getWidth() / OCTOPUS_FRAME_COLS,
                octopusTexture.getHeight() / OCTOPUS_FRAME_ROWS);
        TextureRegion[][] octopusFlippedSprites = TextureRegion.split(octopusFlippedTexture,
                octopusFlippedTexture.getWidth() / OCTOPUS_FRAME_COLS,
                octopusFlippedTexture.getHeight() / OCTOPUS_FRAME_ROWS);

        TextureRegion[] walkingUpFrames = new TextureRegion[4];
        TextureRegion[] walkingDownFrames = new TextureRegion[4];
        TextureRegion[] walkingLeftFrames = new TextureRegion[4];
        TextureRegion[] walkingRightFrames = new TextureRegion[4];
        TextureRegion[] deadFrames = new TextureRegion[4];

        walkingDownFrames[0] = octopusSprites[0][0];
        walkingDownFrames[1] = octopusSprites[0][1];
        walkingDownFrames[2] = octopusSprites[0][2];
        walkingDownFrames[3] = octopusSprites[0][3];

        walkingUpFrames[0] = octopusSprites[0][4];
        walkingUpFrames[1] = octopusSprites[0][5];
        walkingUpFrames[2] = octopusSprites[0][6];
        walkingUpFrames[3] = octopusSprites[0][7];

        walkingLeftFrames[0] = octopusSprites[0][8];
        walkingLeftFrames[1] = octopusSprites[0][9];
        walkingLeftFrames[2] = octopusSprites[0][10];
        walkingLeftFrames[3] = octopusSprites[0][11];

        walkingRightFrames[0] = octopusFlippedSprites[0][4];
        walkingRightFrames[1] = octopusFlippedSprites[0][5];
        walkingRightFrames[2] = octopusFlippedSprites[0][6];
        walkingRightFrames[3] = octopusFlippedSprites[0][7];

        deadFrames[0] = octopusSprites[0][12];
        deadFrames[1] = octopusSprites[0][13];
        deadFrames[2] = octopusSprites[0][14];
        deadFrames[3] = octopusSprites[0][15];

        Animation<TextureRegion> walkingLeftAnimation = new Animation<>(OCTOPUS_FRAME_DURATION, walkingLeftFrames);
        walkingLeftAnimation.setPlayMode(PlayMode.LOOP);

        Animation<TextureRegion> walkingRightAnimation = new Animation<>(OCTOPUS_FRAME_DURATION, walkingRightFrames);
        walkingRightAnimation.setPlayMode(PlayMode.LOOP);

        Animation<TextureRegion> walkingUpAnimation = new Animation<>(OCTOPUS_FRAME_DURATION, walkingUpFrames);
        walkingUpAnimation.setPlayMode(PlayMode.LOOP);

        Animation<TextureRegion> walkingDownAnimation = new Animation<>(OCTOPUS_FRAME_DURATION, walkingDownFrames);
        walkingDownAnimation.setPlayMode(PlayMode.LOOP);

        Animation<TextureRegion> deadAnimation = new Animation<>(OCTOPUS_FRAME_DURATION, deadFrames);
        deadAnimation.setPlayMode(PlayMode.NORMAL);

        octopusAnimations.put(WALKING_LEFT_KEY, walkingLeftAnimation);
        octopusAnimations.put(WALKING_RIGHT_KEY, walkingRightAnimation);
        octopusAnimations.put(WALKING_UP_KEY, walkingUpAnimation);
        octopusAnimations.put(WALKING_DOWN_KEY, walkingDownAnimation);
        octopusAnimations.put(DYING_KEY, deadAnimation);
    }

    public static Animation<TextureRegion> loadBombAnimation() {

        Texture bombTexture = new Texture(Gdx.files.internal("sprites/bombs1.png"));
        TextureRegion[][] bombSprites = TextureRegion.split(bombTexture,
                bombTexture.getWidth() / BOMB_FRAME_COLS,
                bombTexture.getHeight() / BOMB_FRAME_ROWS);

        TextureRegion[] burningFrames = new TextureRegion[3];

        for (int i = 0; i < 3; i++) {
            burningFrames[i] = bombSprites[0][i];
        }

        Animation<TextureRegion> burningAnimation = new Animation<>(BOMB_FRAME_DURATION, burningFrames);
        burningAnimation.setPlayMode(PlayMode.LOOP);

        return burningAnimation;
    }

    public static void loadFlameAnimations(HashMap<String, Animation<TextureRegion>> flameAnimations) {
        Texture flameTexture = new Texture(Gdx.files.internal("sprites/flames.png"));
        TextureRegion[][] flameSprites = TextureRegion.split(flameTexture,
                flameTexture.getWidth() / FLAME_FRAME_COLS,
                flameTexture.getHeight() / FLAME_FRAME_ROWS);

        TextureRegion[] centerFrames = new TextureRegion[4];
        TextureRegion[] verticalFrames = new TextureRegion[4];
        TextureRegion[] horizontalFrames = new TextureRegion[4];

        for (int i = 0; i < 4; i++) {
            centerFrames[i] = flameSprites[0][i];
            verticalFrames[i] = flameSprites[5][i];
            horizontalFrames[i] = flameSprites[2][i];
        }

        Animation<TextureRegion> centerAnimation = new Animation<>(FLAME_FRAME_DURATION, centerFrames);
        centerAnimation.setPlayMode(PlayMode.NORMAL);

        Animation<TextureRegion> verticalAnimation = new Animation<>(FLAME_FRAME_DURATION, verticalFrames);
        verticalAnimation.setPlayMode(PlayMode.NORMAL);

        Animation<TextureRegion> horizontalAnimation = new Animation<>(FLAME_FRAME_DURATION, horizontalFrames);
        horizontalAnimation.setPlayMode(PlayMode.NORMAL);

        flameAnimations.put(CENTER_KEY, centerAnimation);
        flameAnimations.put(VERTICAL_KEY, verticalAnimation);
        flameAnimations.put(HORIZONTAL_KEY, horizontalAnimation);
    }

    public static void loadItemAnimations(HashMap<String, Animation<TextureRegion>> itemAnimations, @NotNull String itemKeyName) {
        Texture itemTexture = new Texture(Gdx.files.internal("sprites/items.png"));
        TextureRegion[][] itemSprites = TextureRegion.split(itemTexture,
                itemTexture.getWidth() / ITEM_FRAME_COLS,
                itemTexture.getHeight() / ITEM_FRAME_ROWS);

        TextureRegion[] itemBackgroundFrames = new TextureRegion[8];
        TextureRegion[] itemImageFrames = new TextureRegion[1];

        int itemBackgroundRow = 4;
        int itemImageRow = 10;
        int itemImageCol = 3;

        switch (itemKeyName) {
            case SPEED_ITEM_KEY:
                itemBackgroundRow = 4;
                itemImageRow = 10;
                itemImageCol = 3;
                break;
            case SUPER_BOMB_ITEM_KEY:
                itemBackgroundRow = 4;
                itemImageRow = 11;
                itemImageCol = 0;
                break;
            case BOMB_SPACE_ITEM_KEY:
                itemBackgroundRow = 1;
                itemImageRow = 10;
                itemImageCol = 7;
                break;
            case SLOW_ITEM_KEY:
                itemBackgroundRow = 2;
                itemImageRow = 11;
                itemImageCol = 5;
                break;
            case LIFE_ITEM_KEY:
                itemBackgroundRow = 3;
                itemImageRow = 11;
                itemImageCol = 6;
                break;
        }

        for (int i = 0; i < 8; i++) {
            itemBackgroundFrames[i] = itemSprites[itemBackgroundRow][i];
        }
        itemImageFrames[0] = itemSprites[itemImageRow][itemImageCol];

        Animation<TextureRegion> itemBackgroundAnimation = new Animation<>(ITEM_FRAME_DURATION, itemBackgroundFrames);
        itemBackgroundAnimation.setPlayMode(PlayMode.LOOP);

        Animation<TextureRegion> itemImageAnimation = new Animation<>(ITEM_FRAME_DURATION, itemImageFrames);
        itemImageAnimation.setPlayMode(PlayMode.LOOP);

        itemAnimations.put(ITEM_BACKGROUND_KEY, itemBackgroundAnimation);
        itemAnimations.put(ITEM_IMAGE_KEY, itemImageAnimation);
    }
}
