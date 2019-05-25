package com.ark.auth;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;

public abstract class BaseAuthBuildForZFB extends BaseAuthBuild {
    protected boolean isShowLoading = true;
    protected String mOrderInfo;
    protected String mUri;

    protected BaseAuthBuildForZFB(@NonNull Context context) {
        super(context, Auth.WithZFB);
    }

    @NonNull
    @Override
    public BaseAuthBuildForZFB setAction(@Auth.ActionZFB int action) {
        mAction = action;
        return this;
    }

    @NonNull
    public BaseAuthBuildForZFB payOrderInfo(@NonNull String orderInfo) {
        mOrderInfo = orderInfo;
        return this;
    }

    @NonNull
    public BaseAuthBuildForZFB payIsShowLoading(boolean isShow) {
        isShowLoading = isShow;
        return this;
    }

    @NonNull
    public BaseAuthBuildForZFB rouseWeb(String uri) {
        mUri = uri;
        return this;
    }

    protected abstract void pay(@NonNull Activity activity);
}