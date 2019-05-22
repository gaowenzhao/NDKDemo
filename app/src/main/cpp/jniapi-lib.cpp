#include <jni.h>
#include <string>
#include <iostream>

#define XONGFUNC(name)Java_com_zhao_myndkapplication_##name
extern "C" JNIEXPORT jclass JNICALL
XONGFUNC(JNIApiUtils_findClass)(
        JNIEnv *env,
        jobject,jstring name) {
     const char *className = env->GetStringUTFChars(name,NULL);
//    const char *text = "java/util/List";
    const char *text = "com/zhao/myndkapplication/MainActivity";
//     env->FindClass(text);
//     env->FindClass(className);
     env->ReleaseStringUTFChars(name,className);
     return  env->FindClass(text);
}
extern "C" JNIEXPORT void JNICALL
XONGFUNC(JNIApiUtils_getMethodIDAndCall)(
        JNIEnv *env,
        jobject,jobject mObject,jstring methodName,jstring toast) {
     const char *name =  env->GetStringUTFChars(methodName,NULL);
     jclass clzz = env->GetObjectClass(mObject);
     jmethodID methodID = env->GetMethodID(clzz,name,"(Ljava/lang/String;)V");
//     env->NewString()
     env->CallVoidMethod(mObject,methodID,toast);
}

extern "C" JNIEXPORT jint JNICALL
XONGFUNC(JNIApiUtils_setIntValue)(
        JNIEnv *env,jobject,jobject mObject,jstring name,jint value) {
    const char *fieldName =  env->GetStringUTFChars(name,NULL);
    jclass clzz = env->GetObjectClass(mObject);
    jfieldID fieldID = env->GetFieldID(clzz,fieldName,"I");
    env->SetIntField(mObject,fieldID,value);
    jint mValue = env->GetIntField(mObject,fieldID);
    return mValue;
}

extern "C" JNIEXPORT jstring JNICALL
XONGFUNC(JNIApiUtils_setStringValue)(
        JNIEnv *env,jobject,jobject mObject,jstring name,jstring value) {
    const char *fieldName =  env->GetStringUTFChars(name,NULL);
    jclass clzz = env->GetObjectClass(mObject);
    jfieldID fieldID = env->GetFieldID(clzz,fieldName,"Ljava/lang/String;");
    env->SetObjectField(mObject,fieldID,value);
    jstring mValue = static_cast<jstring>(env->GetObjectField(mObject, fieldID));
    env->ReleaseStringUTFChars(name,fieldName);
    return mValue;
}
extern "C" JNIEXPORT jobject JNICALL
XONGFUNC(JNIApiUtils_setObjectsValue)(
        JNIEnv *env,jobject,jobject mObject,jstring name,jobject value) {
    const char *fieldName =  env->GetStringUTFChars(name,NULL);
    jclass clzz = env->GetObjectClass(mObject);
    jfieldID fieldID = env->GetFieldID(clzz,fieldName,"Lcom/zhao/myndkapplication/TextBean;");
    env->ReleaseStringUTFChars(name,fieldName);
    return  env->GetObjectField(mObject,fieldID);
}

extern "C" JNIEXPORT jstring JNICALL
 XONGFUNC(JNIApiUtils_newString)(JNIEnv *env,jobject,jstring jtext){
    const char *text = env->GetStringUTFChars(jtext,NULL);
    char cap[128] = "hahah";
//    strcpy(cap, text);//覆盖cap
    strcat(cap,text);// text添加到cap后面

    return  env->NewStringUTF(cap);
}


