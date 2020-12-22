//
// Created by david on 2020/12/22.
//


#include <jni.h>

//申明main 方法
extern "C"{
    extern int main(int argc,char * argv[]);
}


//extern "C"
//JNIEXPORT void JNICALL
//Java_com_example_bsdiff_MainActivity_bsPatch(JNIEnv *env, jobject instance, jstring oldApk_,
//jstring patch_, jstring outPut_) {
//
////将Java字符串转化成c/c++字符串（转化成UTF-8格式的char指针）
//const char *oldApk = env->GetStringUTFChars(oldApk_, 0);
//const char *patch = env->GetStringUTFChars(patch_, 0);
//const char *outPut = env->GetStringUTFChars(outPut_, 0);
//
//const char * argv[]={"bsptch",oldApk,outPut,patch};
//main(4,const_cast<char **>(argv));
//
////释放指针
//env->ReleaseStringUTFChars(oldApk_, oldApk);
//env->ReleaseStringUTFChars(patch_, patch);
//env->ReleaseStringUTFChars(outPut_, outPut);
//}

extern "C"
JNIEXPORT void JNICALL
Java_com_jsean_lib_1bspatch_BsPatchUtil_bsPatch(JNIEnv *env, jobject instance, jstring oldApk_,
                                                jstring patch_, jstring outPut_) {

    //将Java字符串转化成c/c++字符串（转化成UTF-8格式的char指针）
    const char *oldApk = env->GetStringUTFChars(oldApk_, 0);
    const char *patch = env->GetStringUTFChars(patch_, 0);
    const char *outPut = env->GetStringUTFChars(outPut_, 0);

    const char * argv[]={"bsptch",oldApk,outPut,patch};
    main(4,const_cast<char **>(argv));

    //释放指针
    env->ReleaseStringUTFChars(oldApk_, oldApk);
    env->ReleaseStringUTFChars(patch_, patch);
    env->ReleaseStringUTFChars(outPut_, outPut);
}