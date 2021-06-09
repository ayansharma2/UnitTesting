package com.ayan.unittesting

object NonAndroid {
    fun login(userName:String, password:String,confirmPassword:String):Boolean{
        if(userName.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()){
            return false;
        }
        if(password != confirmPassword){
            return false;
        }
        if(password.length<7){
            return false;
        }
        var count=0
        repeat(password.length) {
            if(password[it].isDigit()){
                count++;
            }
        }
        if(count<2)
            return false
        return true
    }
}