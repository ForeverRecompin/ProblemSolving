using namespace std;
#include <iostream>
#include <vector>
#define DEBUG if (1)
#define endl "\n"
typedef vector<int> vi;

int maxSubArray(const vector<int> &A) {
  int i, lenOfA = A.size(), maxEndingHere = A[0], maxSoFar = A[0];
  cout << "\t" << lenOfA << endl;
  for (i = 1; i < lenOfA; i++) {
    maxEndingHere = max(A[i],maxEndingHere+A[i]);
    maxSoFar = max(maxSoFar,maxEndingHere);
  }
  return maxSoFar;
}

int main(int argc, char *argv[]) {
  int tc;
  cin >> tc;
  for (int i = 0; i < tc; i++) {
    vi A;
    int n, elem;
    cin >> n;
    while (n--) {
      cin >> elem;
      A.push_back(elem);
    }
    cout << maxSubArray(A) << endl;
  }
  return 0;
}

