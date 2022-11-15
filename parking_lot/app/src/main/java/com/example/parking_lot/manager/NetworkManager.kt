package com.example.parking_lot.manager

import com.example.parking_lot.api.Service
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 * Created by Ricky on 4/7/21.
 */
object NetworkManager {
    private const val API_CLIENT_TIME_OUT_SEC: Long = 90

    //    lateinit var handShakeService: HandShakeService
    lateinit var service: Service
    fun init(apiURL: String) {
//        handShakeService = getHandShakeRetrofit(handshakeURL).create(HandShakeService::class.java)
        service = getDBSRetrofit(apiURL).create(Service::class.java)
    }

    private fun getDBSRetrofit(apiURL: String): Retrofit {
        return Retrofit.Builder()
            .baseUrl(apiURL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(getSSLHttpClient())
            .build()
    }

    private fun getSSLHttpClient() = getHttpClientBuilder().build()

//    private fun setHttpClientCert(builder: OkHttpClient.Builder) {
//        val sslContext = SSLContext.getInstance("TLS")
//        val publicKeys = mutableListOf<String>()
//        val ca = KeyPinStore.keyStore.getCertificate(it)
//        val trustManager = DBSX509TrustManager(KeyPinStore.keyStore, publicKeys)
//        sslContext.init(null, arrayOf<TrustManager>(trustManager), null)
//        builder.sslSocketFactory(sslContext.socketFactory, trustManager)
//    }

    private fun getHttpClientBuilder(): OkHttpClient.Builder {
        val builder = OkHttpClient.Builder()
            .connectTimeout(API_CLIENT_TIME_OUT_SEC, TimeUnit.SECONDS)
            .readTimeout(API_CLIENT_TIME_OUT_SEC, TimeUnit.SECONDS)
            .writeTimeout(API_CLIENT_TIME_OUT_SEC, TimeUnit.SECONDS)
        builder.addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
        return builder
    }

//    private fun getHandShakeRetrofit(handshakeURL: String): Retrofit {
//        return Retrofit.Builder()
//            .baseUrl(handshakeURL)
//            .addConverterFactory(GsonConverterFactory.create())
//            .client(getSSLHttpClient())
//            .build()
//    }
}