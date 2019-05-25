package com.ark.auth;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.support.annotation.NonNull;

public abstract class BaseAuthBuildForWX extends BaseAuthBuild {
  protected int mShareType = -100;                                      // 分享类型
  protected String mID;                                                 // 小程序 ID
  protected String mPath;                                               // 小程序 Path

  protected String mPartnerId;
  // 微信支付 PartnerId. 微信支付分配的商户号
  protected String mPrepayId;                                           // 微信返回的支付交易会话ID
  protected String mPackageValue;
  // 暂填写固定值Sign=WXPay, 但还是由外部传入, 避免以后变更
  protected String mNonceStr;                                           // 随机字符串，不长于32位
  protected String mTimestamp;                                          // 时间戳
  protected String mPaySign;                                            // 签名

  protected String mTitle;                                              // 标题
  protected String mText;                                               // 文本
  protected String mDescription;                                        // 描述
  protected Bitmap mBitmap;                                             // 图片
  protected String mUrl;                                                // Url

  protected BaseAuthBuildForWX(@NonNull Context context) {
    super(context, Auth.WithWX);
  }

  protected abstract Controller getController(@NonNull Activity activity);

  @Override
  public BaseAuthBuildForWX setAction(@Auth.ActionWX int action) {
    mAction = action;
    return this;
  }

  @NonNull
  public BaseAuthBuildForWX rouseWeb(@NonNull String url) {
    mUrl = url;
    return this;
  }

  @NonNull
  public BaseAuthBuildForWX payPartnerId(@NonNull String partnerId) {
    mPartnerId = partnerId;
    return this;
  }

  @NonNull
  public BaseAuthBuildForWX payPrepayId(@NonNull String prepayId) {
    mPrepayId = prepayId;
    return this;
  }

  @NonNull
  public BaseAuthBuildForWX payPackageValue(@NonNull String value) {
    mPackageValue = value;
    return this;
  }

  @NonNull
  public BaseAuthBuildForWX payNonceStr(@NonNull String str) {
    mNonceStr = str;
    return this;
  }

  @NonNull
  public BaseAuthBuildForWX payTimestamp(@NonNull String time) {
    mTimestamp = time;
    return this;
  }

  @NonNull
  public BaseAuthBuildForWX paySign(@NonNull String sign) {
    mPaySign = sign;
    return this;
  }

  public abstract BaseAuthBuildForWX shareToSession();

  public abstract BaseAuthBuildForWX shareToTimeline();

  public abstract BaseAuthBuildForWX shareToFavorite();

  @NonNull
  public BaseAuthBuildForWX shareText(@NonNull String text) {
    mText = text;
    return this;
  }

  @NonNull
  public BaseAuthBuildForWX shareTextTitle(@NonNull String title) {
    mTitle = title;
    return this;
  }

  @NonNull
  public BaseAuthBuildForWX shareTextDescription(@NonNull String description) {
    mDescription = description;
    return this;
  }

  @NonNull
  public BaseAuthBuildForWX shareImage(@NonNull Bitmap bitmap) {              // imageData 大小限制为 10MB
    mBitmap = bitmap;
    return this;
  }

  @NonNull
  public BaseAuthBuildForWX shareImageTitle(@NonNull String title) {
    mTitle = title;
    return this;
  }

  @NonNull
  public BaseAuthBuildForWX shareMusicTitle(@NonNull String title) {
    mTitle = title;
    return this;
  }

  @NonNull
  public BaseAuthBuildForWX shareMusicDescription(@NonNull String description) {
    mDescription = description;
    return this;
  }

  @NonNull
  public BaseAuthBuildForWX shareMusicImage(@NonNull Bitmap bitmap) {
    mBitmap = bitmap;
    return this;
  }

  /**
   * 网络链接
   */
  @NonNull
  public BaseAuthBuildForWX shareMusicUrl(@NonNull String url) {
    mUrl = url;
    return this;
  }

  @NonNull
  public BaseAuthBuildForWX shareLinkTitle(@NonNull String title) {
    mTitle = title;
    return this;
  }

  @NonNull
  public BaseAuthBuildForWX shareLinkDescription(@NonNull String description) {
    mDescription = description;
    return this;
  }

  @NonNull
  public BaseAuthBuildForWX shareLinkImage(@NonNull Bitmap bitmap) {
    mBitmap = bitmap;
    return this;
  }

  /**
   * 网络链接
   */
  @NonNull
  public BaseAuthBuildForWX shareLinkUrl(@NonNull String url) {
    mUrl = url;
    return this;
  }

  @NonNull
  public BaseAuthBuildForWX shareVideoTitle(@NonNull String title) {
    mTitle = title;
    return this;
  }

  @NonNull
  public BaseAuthBuildForWX shareVideoDescription(@NonNull String description) {
    mDescription = description;
    return this;
  }

  @NonNull
  public BaseAuthBuildForWX shareVideoImage(@NonNull Bitmap bitmap) {
    mBitmap = bitmap;
    return this;
  }

  /**
   * 网络链接
   */
  @NonNull
  public BaseAuthBuildForWX shareVideoUrl(@NonNull String url) {
    mUrl = url;
    return this;
  }

  @NonNull
  public BaseAuthBuildForWX shareProgramTitle(@NonNull String title) {             // 分享小程序
    mTitle = title;
    return this;
  }

  @NonNull
  public BaseAuthBuildForWX shareProgramDescription(@NonNull String description) {
    mDescription = description;
    return this;
  }

  @NonNull
  public BaseAuthBuildForWX shareProgramImage(@NonNull Bitmap bitmap) {
    mBitmap = bitmap;
    return this;
  }

  /**
   * 低版本微信打开的网络链接
   */
  @NonNull
  public BaseAuthBuildForWX shareProgramUrl(@NonNull String url) {
    mUrl = url;
    return this;
  }

  @NonNull
  public BaseAuthBuildForWX shareProgramId(@NonNull String id) {
    mID = id;
    return this;
  }

  @NonNull
  public BaseAuthBuildForWX shareProgramPath(@NonNull String path) {
    mPath = path;
    return this;
  }

  public interface Controller {
    void destroy();

    void callback();
  }
}