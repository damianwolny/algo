package com.company;

public class LongestSequence {



    public static void main(String[] args) {

        char[] arr =  {'A', 'A', 'A', 'B', 'A','B','A','B','A','B','C','C','C','C'};


        System.out.println(findSequence(arr));
longestSequence(arr);


    }

    public static void longestSequence(char[] a) {
        int count = 1, max = 1;

        for (int i = 1; i < a.length; i++) {
            if (a[i] == a[i - 1]) {
                count++;
            } else {
//                if (count > max) {
//                    max = count;
//                }
                count = 1;
            }
        }

        if (count> max)
            System.out.println(count);
        else
            System.out.println(max);

    }

    static char findSequence(char [] arr){

        int frequency=1;
        char bestChar=arr[0];
        int bestFrequency=0;

        for(int n=1;n< arr.length;n++){
            if(arr[n]!=arr[n-1]){
                if(frequency>bestFrequency){
                    bestChar=arr[n-1];
                    bestFrequency=frequency;
                }
                frequency=1;
            }else {
                frequency++;
            }
        }

        if( frequency>bestFrequency){
            bestChar=arr[arr.length-1];
        }

        return bestChar;
    }
}
