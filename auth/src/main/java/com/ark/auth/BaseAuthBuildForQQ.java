package com.ark.auth;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import java.util.ArrayList;

public abstract class BaseAuthBuildForQQ extends BaseAuthBuild {
  protected String mTitle;                                          // 标题
  protected String mDescription;                                    // 描述
  protected String mUrl;                                            // Url

  protected String mImageUrl;                                       // 图片 url
  protected String mAudioUrl;                                       // 音频 url
  protected String mArk;
  protected String mName;
  protected Boolean mQzone = null;
  protected boolean mMood = false;
  protected boolean mMultiImage = false;
  protected String mBack;
  protected String mScene;
  protected ArrayList<String> mImageList;
  // 图片集合, 最多支持9张图片，多余的图片会被丢弃; 说说 <=9张图片为发表说说，>9张为上传图片到相册,只支持本地图片

  public BaseAuthBuildForQQ(@NonNull Context context) {
    super(context, Auth.WithQQ);
  }

  public abstract Controller getController(@NonNull Activity activity);

  @NonNull
  @Override
  public BaseAuthBuildForQQ setAction(@Auth.ActionQQ int action) {
    mAction = action;
    return this;
  }

  /**
   * 三种状态: 默认是不隐藏分享到QZone按钮且不自动打开分享到QZone的对话框(true, 直接打开QZone的对话框, false 隐藏分享到QZone)
   */
  @NonNull
  public BaseAuthBuildForQQ shareToQzone(boolean qzone) {
    mQzone = qzone;
    return this;
  }

  /**
   * 分享到说说
   */
  @NonNull
  public BaseAuthBuildForQQ shareImageToMood() {
    mMood = true;
    return this;
  }

  /**
   * 单图只支持本地路径, 图文支持分享图片的URL或者本地路径, 不设置 Title 为单图, 否则为多图或图文
   */
  @NonNull
  public BaseAuthBuildForQQ shareImageUrl(@NonNull String url) {
    mImageUrl = url;
    return this;
  }

  /**
   * 最长 30 个字符
   */
  @NonNull
  public BaseAuthBuildForQQ shareImageTitle(@NonNull String title) {
    mTitle = title;
    return this;
  }

  /**
   * 网络链接, 点击后跳转 url
   */
  @NonNull
  public BaseAuthBuildForQQ shareImageTargetUrl(@NonNull String url) {
    mUrl = url;
    return this;
  }

  @NonNull
  public BaseAuthBuildForQQ shareImageDescription(@NonNull String description) {
    mDescription = description;
    return this;
  }

  // 手Q客户端顶部，替换“返回”按钮文字，如果为空，用返回代替              // 测试后无效果
  @NonNull
  public BaseAuthBuildForQQ shareImageName(@NonNull String name) {
    mName = name;
    return this;
  }

  /**
   * 可选, 分享携带ARK JSON串
   */
  @NonNull
  public BaseAuthBuildForQQ shareImageArk(@NonNull String ark) {
    mArk = ark;
    return this;
  }

  /**
   * 可选, 调用了 shareImageToMood 后生效, 区分分享场景，用于异化feeds点击行为和小尾巴展示
   */
  @NonNull
  public BaseAuthBuildForQQ shareImageScene(@NonNull String scene) {
    mScene = scene;
    return this;
  }

  /**
   * 可选, 调用了 shareImageToMood 后生效, 游戏自定义字段，点击分享消息回到游戏时回传给游戏
   */
  @NonNull
  public BaseAuthBuildForQQ shareImageBack(@NonNull String back) {
    mBack = back;
    return this;
  }

  /**
   * 调用后 shareImageUrl 失效, 且默认为(仅支持)发表到QQ空间, 以便支持多张图片（注：图片最多支持9张图片，多余的图片会被丢弃）
   * QZone接口暂不支持发送多张图片的能力，若传入多张图片，则会自动选入第一张图片作为预览图。多图的能力将会在以后支持
   * <p>
   * 如果调用了 shareToMood 则发表说说: 说说的图片, 以ArrayList<String>的类型传入，以便支持多张图片（注：<=9张图片为发表说说，>9张为上传图片到相册），只支持本地图片
   */
  @NonNull
  public BaseAuthBuildForQQ shareImageMultiImage(@NonNull ArrayList<String> list) {
    mMultiImage = true;
    mImageList = list;
    return this;
  }

  @NonNull
  public BaseAuthBuildForQQ shareMusicTitle(@NonNull String title) {
    mTitle = title;
    return this;
  }

  /**
   * 音乐文件的远程链接, 以URL的形式传入, 不支持本地音乐
   */
  @NonNull
  public BaseAuthBuildForQQ shareMusicUrl(@NonNull String url) {
    mAudioUrl = url;
    return this;
  }

  /**
   * 网络链接
   */
  @NonNull
  public BaseAuthBuildForQQ shareMusicTargetUrl(@NonNull String url) {
    mUrl = url;
    return this;
  }

  /**
   * 分享图片的URL或者本地路径
   */
  @NonNull
  public BaseAuthBuildForQQ shareMusicImage(@NonNull String urlOrPath) {
    mImageUrl = urlOrPath;
    return this;
  }

  @NonNull
  public BaseAuthBuildForQQ shareMusicDescription(@NonNull String description) {
    mDescription = description;
    return this;
  }

  @NonNull
  public BaseAuthBuildForQQ shareMusicName(@NonNull String name) {
    mName = name;
    return this;
  }

  @NonNull
  public BaseAuthBuildForQQ shareVideoUrl(@NonNull String url) {
    mUrl = url;
    return this;
  }

  @NonNull
  public BaseAuthBuildForQQ shareVideoScene(@NonNull String scene) {
    mScene = scene;
    return this;
  }

  @NonNull
  public BaseAuthBuildForQQ shareVideoBack(@NonNull String back) {
    mBack = back;
    return this;
  }

  @NonNull
  public BaseAuthBuildForQQ shareProgramTitle(@NonNull String title) {
    mTitle = title;
    return this;
  }

  @NonNull
  public BaseAuthBuildForQQ shareProgramDescription(@NonNull String description) {
    mDescription = description;
    return this;
  }

  /**
   * 分享图片的URL或者本地路径
   */
  @NonNull
  public BaseAuthBuildForQQ shareProgramImage(@NonNull String urlOrPath) {
    mImageUrl = urlOrPath;
    return this;
  }

  @NonNull
  public BaseAuthBuildForQQ shareProgramName(@NonNull String name) {
    mName = name;
    return this;
  }

  public interface Controller {
    void destroy();

    void callback(int requestCode, int resultCode, @Nullable Intent data);
  }
}