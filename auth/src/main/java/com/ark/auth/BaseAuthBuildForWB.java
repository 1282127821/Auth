package com.ark.auth;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import java.util.ArrayList;

public abstract class BaseAuthBuildForWB extends BaseAuthBuild {
  protected String mTitle;                                          // 标题
  protected String mText;                                           // 文本
  protected String mDescription;                                    // 描述
  protected Bitmap mBitmap;                                         // 图片
  protected String mUrl;                                            // Url

  protected Uri mUri;                                               // 微博 Uri 地址
  protected boolean mStory = false;                                 // 微博 是否分享到微博故事, 仅支持单图 和 视频
  protected boolean mMultiImage = false;                            // 是否是多图分享
  protected ArrayList<Uri> mImagePathList;                          // 微博 多图路径地址

  protected BaseAuthBuildForWB(@NonNull Context context) {
    super(context, Auth.WithWB);
  }

  protected abstract Controller getController(@NonNull Activity activity);

  @NonNull
  @Override
  public BaseAuthBuildForWB setAction(@Auth.ActionWB int action) {
    mAction = action;
    return this;
  }

  /**
   * 是否分享到微博故事, 仅支持单图 和 视频
   * 如果分享视频到微博故事, shareVideoUri shareVideoTitle shareVideoText shareVideoDescription 将失效, 只使用 uri 内容
   * , Uri 为本地视频
   */
  @NonNull
  public BaseAuthBuildForWB shareToStory() {
    mStory = true;
    return this;
  }

  @NonNull
  public BaseAuthBuildForWB shareText(@NonNull String text) {
    mText = text;
    return this;
  }

  @NonNull
  public BaseAuthBuildForWB shareImage(@NonNull Bitmap bitmap) {              // imageData 大小限制为 2MB
    mBitmap = bitmap;
    return this;
  }

  @NonNull
  public BaseAuthBuildForWB shareImageText(@NonNull String text) {
    mText = text;
    return this;
  }

  /**
   * 分享多张图片, 本地图片 Uri 集合, shareImage 失效
   */
  @NonNull
  public BaseAuthBuildForWB shareImageMultiImage(@NonNull ArrayList<Uri> list) {
    mMultiImage = true;
    mImagePathList = list;
    return this;
  }

  /**
   * 分享图片到微博故事时调用, shareImage shareImageText 将失效, 只使用 uri 内容, Uri 为本地图片
   */
  @NonNull
  public BaseAuthBuildForWB shareImageUri(@NonNull Uri uri) {
    mUri = uri;
    return this;
  }

  @NonNull
  public BaseAuthBuildForWB shareLinkTitle(@NonNull String title) {
    mTitle = title;
    return this;
  }

  @NonNull
  public BaseAuthBuildForWB shareLinkDescription(@NonNull String description) {
    mDescription = description;
    return this;
  }

  @NonNull
  public BaseAuthBuildForWB shareLinkImage(@NonNull Bitmap bitmap) {
    mBitmap = bitmap;
    return this;
  }

  /**
   * 网络链接
   */
  @NonNull
  public BaseAuthBuildForWB shareLinkUrl(@NonNull String url) {
    mUrl = url;
    return this;
  }

  @NonNull
  public BaseAuthBuildForWB shareLinkText(@NonNull String text) {
    mText = text;
    return this;
  }

  @NonNull
  public BaseAuthBuildForWB shareVideoTitle(@NonNull String title) {
    mTitle = title;
    return this;
  }

  @NonNull
  public BaseAuthBuildForWB shareVideoText(@NonNull String text) {
    mText = text;
    return this;
  }

  @NonNull
  public BaseAuthBuildForWB shareVideoDescription(@NonNull String description) {
    mDescription = description;
    return this;
  }

  /**
   * 本地视频 Uri
   */
  @NonNull
  public BaseAuthBuildForWB shareVideoUri(@NonNull Uri uri) {
    mUri = uri;
    return this;
  }

  public interface Controller {
    void destroy();

    void callbackShare();

    void callbackSso(int requestCode, int resultCode, @Nullable Intent data);
  }
}