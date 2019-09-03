package com.comers.processor;

import com.squareup.javapoet.ClassName;
import com.squareup.javapoet.JavaFile;
import com.squareup.javapoet.MethodSpec;
import com.squareup.javapoet.TypeSpec;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Arrays;

import javax.lang.model.element.Modifier;

public class ClassProducter {
    public static void main(String[] args) {
     /*   //构建类
        TypeSpec.Builder classBuild=TypeSpec.classBuilder("ProcessorActivity")
                .addModifiers(Modifier.PUBLIC)
                .superclass(ClassName.get("android.app","Activity"));
        //构建方法
        MethodSpec onCreate= MethodSpec.methodBuilder("onCreate")
                .addAnnotation(ClassName.get("java.lang","Override"))
                .addModifiers(Modifier.PROTECTED)
                .addParameter(ClassName.get("android.os","Bundle"),"savedInstanceState")
                .addStatement("super.onCreate(savedInstanceState)")
                .addStatement("setContentView(R.layout.activity_main)")
                .build();
        //构建 文件
        JavaFile javaFile= JavaFile.builder("com.comers.processor",classBuild.addMethod(onCreate).build()).build();
        //写文件
        try {
            javaFile.writeTo(new File("/Volumes/Work/works/NewFrame/app/src/main/java/com/comers/shenwu/camera/"));
        } catch (IOException e) {
            e.printStackTrace();
        }*/

        TypeSpec.Builder classBuilder = TypeSpec.classBuilder("ProcessorHelper")
                .addModifiers(Modifier.PUBLIC);

        MethodSpec constructer = MethodSpec.methodBuilder("ProcessorHelper")
                .addModifiers(Modifier.PUBLIC)
                .build();

        JavaFile javaFile = JavaFile.builder("com.comers.processor", classBuilder.addMethod(constructer).build()).build();

        try {
            javaFile.writeTo(new File("/Volumes/Work/works/NewFrame/processor/src/main/java/com/comers/processor"));
        } catch (Exception e) {

        }


//        int[] nums = new int[]{6, 3, 7, 4, 2, 8};
//        segment(nums, 0, nums.length - 1);
//        System.out.println(Arrays.toString(nums));

    }

    //分割
    public static void segment(int[] nums, int left, int right) {
        if (left < right) {
            int center = (left + right) / 2;
            segment(nums, left, center);
            segment(nums, center + 1, right);
            merge(nums, left, center, right);
        }

    }

    //合并
    private static void merge(int[] nums, int left, int center, int right) {

//            int[] tmpArray = new int[right - left + 1];
//            int leftIndex = left;   //左数组第一个元素的索引
//            int rightIndex = center + 1;   //右数组第一个元素索引
//            int tmpIndex = 0;    //临时数组索引
//
//            // 把较小的数先移到新数组中
//            while (leftIndex <= center && rightIndex <= right) {
//                if (nums[leftIndex] <= nums[rightIndex]) {
//                    tmpArray[tmpIndex++] = nums[leftIndex++];
//                } else {
//                    tmpArray[tmpIndex++] = nums[rightIndex++];
//                }
//            }
//
//            // 把左边剩余的数移入数组
//            while (leftIndex <= center) {
//                tmpArray[tmpIndex++] = nums[leftIndex++];
//            }
//
//            // 把右边边剩余的数移入数组
//            while (rightIndex <= right) {
//                tmpArray[tmpIndex++] = nums[rightIndex++];
//            }


        //用来临时存入有序的arrary
        int[] tempArray = new int[right - left + 1];
        int leftIndex = left;
        int rightIndex = center + 1;
        int tempIndex = 0;
        //将左右两边小数放到tempArray里面
        while (leftIndex <= center && rightIndex <= right) {
            if (nums[leftIndex] <= nums[rightIndex]) {
                tempArray[tempIndex++] = nums[leftIndex++];
            } else {
                tempArray[tempIndex++] = nums[rightIndex++];
            }
        }
        // 把左边剩余的数移入数组
        while (leftIndex <= center) {
            tempArray[tempIndex++] = nums[leftIndex++];
        }

        // 把右边边剩余的数移入数组
        while (rightIndex <= right) {
            tempArray[tempIndex++] = nums[rightIndex++];
        }

        //将nums数据更换为tempArray
        System.arraycopy(tempArray, 0, nums, left, tempArray.length);
    }
    /*public static void main(String[] args) {
        int[] nums = {6, 5, 3, 8, 1, 7, 2, 9, 4};
        segment(nums, 0, nums.length - 1);
        System.out.println(Arrays.toString(nums));
    }

    *//**
     * 递归切分待排
     *
     * @param nums  待切分数组
     * @param left  待切分最后第一个元素的索引
     * @param right 待切分数组最后一个元素的索引
     *//*
    private static void segment(int[] nums, int left, int right) {
        if (left < right) {
            // 找出中间索引
            int center = (left + right) / 2;
            // 对左边数组进行递归
            segment(nums, left, center);
            // 对右边数组进行递归
            segment(nums, center + 1, right);
            // 合并
            merge(nums, left, center, right);
        }
    }

    *//**
     * 两两归并排好序的数组（2路归并）
     *
     * @param nums   带排序数组对象
     * @param left   左边数组的第一个索引
     * @param center 左数组的最后一个索引，center + 1右数组的第一个索引
     * @param right  右数组的最后一个索引
     *//*
    private static void merge(int[] nums, int left, int center, int right) {
        int[] tmpArray = new int[right - left + 1];
        int leftIndex = left;   //左数组第一个元素的索引
        int rightIndex = center + 1;   //右数组第一个元素索引
        int tmpIndex = 0;    //临时数组索引

        // 把较小的数先移到新数组中
        while (leftIndex <= center && rightIndex <= right) {
            if (nums[leftIndex] <= nums[rightIndex]) {
                tmpArray[tmpIndex++] = nums[leftIndex++];
            } else {
                tmpArray[tmpIndex++] = nums[rightIndex++];
            }
        }

        // 把左边剩余的数移入数组
        while (leftIndex <= center) {
            tmpArray[tmpIndex++] = nums[leftIndex++];
        }

        // 把右边边剩余的数移入数组
        while (rightIndex <= right) {
            tmpArray[tmpIndex++] = nums[rightIndex++];
        }

        // 把新数组中的数覆盖nums数组
    *//*for (int i = 0; i < tmpArray.length; i++) {
        nums[begin + i] = tmpArray[i];
    }*//*
        //可以优化成下面的写法
        System.arraycopy(tmpArray, 0, nums, left, tmpArray.length);
    }
*/

}
