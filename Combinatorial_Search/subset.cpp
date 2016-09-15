#include <stdio.h>
#include <iostream>
#define MAXCANDIDATES   100	/* max possible next extensions */
#define NMAX            100	/* maximum solution size */

typedef char* data;			/* type to pass data to backtrack */
bool finished = false;  /* found all solutions yet? */

void process_solution(int a[], int k)
{
  int i;				/* counter */

  printf("{");
  for (i=1; i<=k; i++)
    if (a[i] == true) printf(" %d",i);

  printf(" }\n");
}

bool is_a_solution(int a[], int k, int n)
{
  return (k == n);
}


/*	What are possible elements of the next slot in the permutation?  */

void construct_candidates(int a[], int k, int n, int c[], int *ncandidates)
{
  c[0] = true;
  c[1] = false;
  *ncandidates = 2;
}

void backtrack(int a[], int k, int input)
{
  int c[MAXCANDIDATES];    /* candidates for next position */
  int ncandidates;         /* next position candidate count */
  int i;                   /* counter */

  if (is_a_solution(a,k,input))
    process_solution(a,k);
  else {
    k = k+1;
    construct_candidates(a,k,input,c,&ncandidates);
    for (i=0; i<ncandidates; i++) {
      a[k] = c[i];
      backtrack(a,k,input);
      if (finished) return;	/* terminate early */
    }
  }
}

main()
{
  int a[NMAX];			/* solution vector */

  backtrack(a,0,4);
}

