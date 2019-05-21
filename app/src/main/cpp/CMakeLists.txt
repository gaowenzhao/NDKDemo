cmake_minimum_required(VERSION 3.4.1)


add_library( # Sets the name of the library.
        nativetest
        SHARED
        native-lib.cpp)

find_library( # Sets the name of the path variable.
        log-lib
        log)
set(export_dir ${CMAKE_CURRENT_SOURCE_DIR}/../../../../export)

#set_target_properties(
#       nativetest
#       PROPERTIES LIBRARY_OUTPUT_DIRECTORY "${export_dir}/lib/${ANDROID_ABI}")

# 添加.so动态库(jsoncpp)
add_library(lib_so_jsoncpp SHARED IMPORTED)
# 导入 libjsoncpp.so库
set_target_properties(
        lib_so_jsoncpp
        PROPERTIES IMPORTED_LOCATION ${export_dir}/lib/${ANDROID_ABI}/libjsoncpp.so)


# 链接头文件
target_include_directories(
        nativetest
        PRIVATE
        # native_so_jsoncpp需要的头文件
        ${export_dir}/libsojsoncpp/include
)


# 链接库
target_link_libraries( # Specifies the target library.
        nativetest
        ${log-lib}
        # 链接 jsoncpp.so
        lib_so_jsoncpp)