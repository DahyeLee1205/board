package com.example.common.entity

class BaseResponse<T> (
    var code : String? = null,
    var status : String? = null,
    var  message : String?= null,
    var  data :T ? = null ,
    var timeStamp : Long ?= System.currentTimeMillis()
){
    companion object{
        fun <T> success(data : T) :BaseResponse<T>{
            return BaseResponse(
                    code = "10000",
                    status = "SUCCESS",
                    message = "요청이 성공적으로 처리되었습니다.",
                    data = data
            )
        }

        fun <T> error(message : String) : BaseResponse<T>{
            return BaseResponse(
                    code = "10999",
                    status = "ERROR",
                    message = message,
                    data = null
            )
        }
    }
}
