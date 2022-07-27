#include<stdio.h>

int main(){
	
    int dizi1[50], dizi2[50], boyut1, boyut2, birles[100], k, i;
    printf("Ilk dizinin boyutu : ");
    scanf("%d", &boyut1);
    printf("Ilk dizinin elemanlarini giriniz : ");
    for(i=0; i<boyut1; i++)
    {
        scanf("%d", &dizi1[i]);
        birles[i] = dizi1[i];
    }
    
    k = i;
    printf("\nIkinci dizinin boyutu : ");
    scanf("%d", &boyut2);
    printf("Ikinci dizinin elemanlarini giriniz : ");
    for(i=0; i<boyut2; i++)
    {
        scanf("%d", &dizi2[i]);
        birles[k] = dizi2[i];
        k++;
    }
    printf("\nIki dizinin birlestirilmis hali : \n");
    for(i=0; i<k; i++)
        printf("%d ", birles[i]);
}