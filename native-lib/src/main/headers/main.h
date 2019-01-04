#pragma once

#if defined(_MSC_VER)
    //  Microsoft
    #define JNIIMPORT __declspec(dllimport)
    #define JNIEXPORT __declspec(dllexport)
#elif defined(__GNUC__) || __has_attribute(__visibility__)
    //  GCC
    #define JNIIMPORT __attribute__((visibility("default")))
    #define JNIEXPORT __attribute__((visibility("default")))
#else
    //  do nothing and hope for the best?
    #define JNIIMPORT
    #define JNIEXPORT
    #pragma warning Unknown dynamic link import/export semantics.
#endif

extern "C" {
    JNIEXPORT void printIt();

    JNIEXPORT char * getHelloWorld();
}