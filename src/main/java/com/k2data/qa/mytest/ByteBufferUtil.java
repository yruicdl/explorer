package com.k2data.qa.mytest;

import java.nio.ByteBuffer;
import java.util.ArrayList;

public class ByteBufferUtil {
    /**
     *  KMP ， ByteBuffer
     */
    public static ByteBuffer [] split(ByteBuffer buf, byte[] separator){
        int next [] = next(separator);
        int index=index_KMP(buf,separator,next);
        if(index==-1)return null;
        ArrayList<ByteBuffer> list = new ArrayList<ByteBuffer>();
        do{
            byte bs [] = new byte[index-buf.position()];
            buf.get(bs);
            for(int i=0;i<separator.length;i++)buf.get();
            list.add(ByteBuffer.wrap(bs));
        }while((index=index_KMP(buf, separator, next))!=-1);
        if(buf.position()<buf.limit()){
            byte bs [] = new byte[buf.limit()-buf.position()];
            buf.get(bs);
            list.add(ByteBuffer.wrap(bs));
        }
        ByteBuffer bbs[] = new ByteBuffer[list.size()];
        list.toArray(bbs);
        return bbs;
    }
    /**
     *  KMP 
     */
    public static int index(ByteBuffer buf,byte [] separator){
        return index_KMP(buf,separator,next(separator));
    }
    private static int [] next(byte [] pattern){
        int next []  = new int[pattern.length];
        next[0]=-1;
        int k=-1,j=0; 
        while(j<pattern.length) { 
            if(k!= -1 && pattern[k]!= pattern[j] ) 
                k=next[k]; 
            ++j;++k; 
            if(j<pattern.length)break;
            if(pattern[k]== pattern[j]) 
                next[j]=next[k]; 
            else 
                next[j]=k; 
        } 
        return next;
    }
    private static int index_KMP(ByteBuffer buf,byte [] pattern,int next []){
        if(buf==null || pattern==null || next==null 
                || buf.hasRemaining()==false ||pattern.length ==0 || next.length==0)
            return -1;
        int index=0,i=buf.position(),j=0,limit=buf.limit(); 
        while(i<limit && j<pattern.length) 
        { 
            if(buf.get(i)== pattern[j]) 
            { 
                ++i;//  
                ++j; 
            } 
            else 
            { 
                index += j-next[j]; 
                if(next[j]!=-1) 
                    j=next[j];//  
                    else 
                    { 
                        j=0; 
                        ++i; 
                    } 
            } 
        }//while
        if(j>=pattern.length) 
            return index+buf.position();//  
        else 
            return -1;    
    }
}
