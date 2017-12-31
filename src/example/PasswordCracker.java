package example;

import java.util.ArrayList;
import java.util.Random;

public class PasswordCracker {
	public static void main(String[] args) {
		new PasswordCracker();
	}

	public PasswordCracker() {
		long startTime = System.currentTimeMillis();
		int[] numbers = { 0, 0, 0, 0, 0, 0, 0, 0 ,0 };
		String word = "";
		int j = 0;
		while (true) {
			word = "";
			numbers[0] = j;
			j = (j + 1) % 100;
			if (j == 0) {
				increment(numbers, 1);
			}
			for (int i = numbers.length - 1; i >= 0; i--) {
				char l = (char) (48 + numbers[i]);
				if (l != '0') {
					word += l;
				}
			}
			if (tryPassword(word)) {
				double time = (System.currentTimeMillis() - startTime) / 1000.00;
				System.out.println("Cracked w/" + word + " time :" + time);
				System.exit(0);
			}
		}
	}

	boolean tryPassword(String pass) {
		
		if (pass.equals("vf9k")) {
			return true;
		}
		return false;
	}

	public void increment(int[] numbers, int pos) {
		numbers[pos] = (numbers[pos] + 1) % 100;
		if (numbers[pos] == 0) {
			increment(numbers, pos + 1);
		}
	}

}
/*
#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include <time.h>

static const char alphabet[] =
        "abcdefghijklmnopqrstuvwxyz"
        "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
        "0123456789!@#$%^&*()";

static const int alphabet_size = sizeof(alphabet) - 1;
static const char pass[5]  = "Lucas";

int tryPassword(char* guess) {
	
	for(int i = 0; i < 5; i++) {
		if(guess[i] != pass[i]) {
			return 0;
		}
	}
	printf("Successful with guess: ");
	printf("%s", guess);
	printf("\n");
	return 1;
}
void brute_impl(char * str, int index, int max_depth)
{
    int i;
    for (i = 0; i < alphabet_size; ++i)
    {
        str[index] = alphabet[i];

        if (index == max_depth - 1)
        {
        	//printf("%s\n", str);
            if (tryPassword(str)==1) {
            	
            }
        }
        else
        {
            brute_impl(str, index + 1, max_depth);
        }
    }
}



void brute_sequential(int max_len)
{
    char * buf = malloc(max_len + 1);
    int i;

    for (i = 1; i <= max_len; ++i)
    {
        memset(buf, 0, max_len + 1);
        brute_impl(buf, 0, i);
    }

    free(buf);
}

int main(void)
{
    brute_sequential(5);
    return 0;
}
*/


