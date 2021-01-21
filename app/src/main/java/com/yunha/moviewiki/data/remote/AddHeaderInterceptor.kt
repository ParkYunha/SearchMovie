package com.yunha.moviewiki.data.remote

import android.os.Build
import com.yunha.moviewiki.BuildConfig
import okhttp3.Interceptor

class AddHeaderInterceptor : Interceptor {

    override fun intercept(chain: Interceptor.Chain) = chain.run {
        proceed(
            request()
                .newBuilder()
                .addHeader("X-Naver-Client-Id", BuildConfig.MOVIE_CLIENT_ID)
                .addHeader("X-Naver-Client-Secret", BuildConfig.MOVIE_CLIENT_SECRET)
                .build()
        )
    }
}
