package com.mort.distributeLockRedis;

import org.junit.Test;
import redis.clients.jedis.Jedis;

/**
 * Author:  lining17
 * Date :  16/01/2018
 */
public class DistributLockRedis {

    private static Jedis jedis;

    DistributLockRedis(){

        //连接redis服务器，192.168.0.100:6379
        this.jedis = new Jedis("127.0.0.1", 6379);
        //权限认证
        //jedis.auth("admin");
    }



    public boolean setLock(){

        while(true){
            Long ret = jedis.setnx("123","121212_1");  //value  时间戳_过期时间
            if(0 == ret.intValue()){   //设置成功
                jedis.expire("123" , 1);
                return true;
            }

            //设置失败 继续获取 防止死锁
            String value = jedis.get("123");
            String[] valArray = value.split("_");
            if(System.currentTimeMillis()
                    > (Integer.valueOf(valArray[0]).intValue() + Integer.valueOf(valArray[1]).intValue())){
                // CAS 操作
               String oldVal =  jedis.getSet("123" , "121213_1");
               if(oldVal.equals(value)){
                   return true ;
               }
            }
        }
//        System.out.println(jedis.get("mort"));
    }


    public boolean releaseLock(){
        jedis.del("123");
        return true;
    }


    class TestLock{

        DistributLockRedis distributLockRedis = new DistributLockRedis();


        @Test
        public void testSet(){
            distributLockRedis.setLock();
        }



    }


    public static void main(String[] args) {
        DistributLockRedis distributLockRedis = new DistributLockRedis();
        distributLockRedis.setLock();
    }

}

