package dev.xfj.format.wmb;

public class WMBBone {
    private short boneNumber;
    private short parentIndex;
    private float positionX;
    private float positionY;
    private float positionZ;
    private float rotationX;
    private float rotationY;
    private float rotationZ;
    private float scaleX;
    private float scaleY;
    private float scaleZ;
    private float worldPositionX;
    private float worldPositionY;
    private float worldPositionZ;
    private float worldRotationX;
    private float worldRotationY;
    private float worldRotationZ;
    private float worldScaleX;
    private float worldScaleY;
    private float worldScaleZ;
    private float worldPositionTPoseX;
    private float worldPositionTPoseY;
    private float worldPositionTPoseZ;

    public short getBoneNumber() {
        return boneNumber;
    }

    public void setBoneNumber(short boneNumber) {
        this.boneNumber = boneNumber;
    }

    public short getParentIndex() {
        return parentIndex;
    }

    public void setParentIndex(short parentIndex) {
        this.parentIndex = parentIndex;
    }

    public float getPositionX() {
        return positionX;
    }

    public void setPositionX(float positionX) {
        this.positionX = positionX;
    }

    public float getPositionY() {
        return positionY;
    }

    public void setPositionY(float positionY) {
        this.positionY = positionY;
    }

    public float getPositionZ() {
        return positionZ;
    }

    public void setPositionZ(float positionZ) {
        this.positionZ = positionZ;
    }

    public float getRotationX() {
        return rotationX;
    }

    public void setRotationX(float rotationX) {
        this.rotationX = rotationX;
    }

    public float getRotationY() {
        return rotationY;
    }

    public void setRotationY(float rotationY) {
        this.rotationY = rotationY;
    }

    public float getRotationZ() {
        return rotationZ;
    }

    public void setRotationZ(float rotationZ) {
        this.rotationZ = rotationZ;
    }

    public float getScaleX() {
        return scaleX;
    }

    public void setScaleX(float scaleX) {
        this.scaleX = scaleX;
    }

    public float getScaleY() {
        return scaleY;
    }

    public void setScaleY(float scaleY) {
        this.scaleY = scaleY;
    }

    public float getScaleZ() {
        return scaleZ;
    }

    public void setScaleZ(float scaleZ) {
        this.scaleZ = scaleZ;
    }

    public float getWorldPositionX() {
        return worldPositionX;
    }

    public void setWorldPositionX(float worldPositionX) {
        this.worldPositionX = worldPositionX;
    }

    public float getWorldPositionY() {
        return worldPositionY;
    }

    public void setWorldPositionY(float worldPositionY) {
        this.worldPositionY = worldPositionY;
    }

    public float getWorldPositionZ() {
        return worldPositionZ;
    }

    public void setWorldPositionZ(float worldPositionZ) {
        this.worldPositionZ = worldPositionZ;
    }

    public float getWorldRotationX() {
        return worldRotationX;
    }

    public void setWorldRotationX(float worldRotationX) {
        this.worldRotationX = worldRotationX;
    }

    public float getWorldRotationY() {
        return worldRotationY;
    }

    public void setWorldRotationY(float worldRotationY) {
        this.worldRotationY = worldRotationY;
    }

    public float getWorldRotationZ() {
        return worldRotationZ;
    }

    public void setWorldRotationZ(float worldRotationZ) {
        this.worldRotationZ = worldRotationZ;
    }

    public float getWorldScaleX() {
        return worldScaleX;
    }

    public void setWorldScaleX(float worldScaleX) {
        this.worldScaleX = worldScaleX;
    }

    public float getWorldScaleY() {
        return worldScaleY;
    }

    public void setWorldScaleY(float worldScaleY) {
        this.worldScaleY = worldScaleY;
    }

    public float getWorldScaleZ() {
        return worldScaleZ;
    }

    public void setWorldScaleZ(float worldScaleZ) {
        this.worldScaleZ = worldScaleZ;
    }

    public float getWorldPositionTPoseX() {
        return worldPositionTPoseX;
    }

    public void setWorldPositionTPoseX(float worldPositionTPoseX) {
        this.worldPositionTPoseX = worldPositionTPoseX;
    }

    public float getWorldPositionTPoseY() {
        return worldPositionTPoseY;
    }

    public void setWorldPositionTPoseY(float worldPositionTPoseY) {
        this.worldPositionTPoseY = worldPositionTPoseY;
    }

    public float getWorldPositionTPoseZ() {
        return worldPositionTPoseZ;
    }

    public void setWorldPositionTPoseZ(float worldPositionTPoseZ) {
        this.worldPositionTPoseZ = worldPositionTPoseZ;
    }

    @Override
    public String toString() {
        return "WMBBone{" +
                "boneNumber=" + boneNumber +
                ", parentIndex=" + parentIndex +
                ", positionX=" + positionX +
                ", positionY=" + positionY +
                ", positionZ=" + positionZ +
                ", rotationX=" + rotationX +
                ", rotationY=" + rotationY +
                ", rotationZ=" + rotationZ +
                ", scaleX=" + scaleX +
                ", scaleY=" + scaleY +
                ", scaleZ=" + scaleZ +
                ", worldPositionX=" + worldPositionX +
                ", worldPositionY=" + worldPositionY +
                ", worldPositionZ=" + worldPositionZ +
                ", worldRotationX=" + worldRotationX +
                ", worldRotationY=" + worldRotationY +
                ", worldRotationZ=" + worldRotationZ +
                ", worldScaleX=" + worldScaleX +
                ", worldScaleY=" + worldScaleY +
                ", worldScaleZ=" + worldScaleZ +
                ", worldPositionTPoseX=" + worldPositionTPoseX +
                ", worldPositionTPoseY=" + worldPositionTPoseY +
                ", worldPositionTPoseZ=" + worldPositionTPoseZ +
                '}';
    }
}
