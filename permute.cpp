#include <iostream>
#include <string>
#define DEBUG if (0)
using std::cin;
using std::cout;
using std::string;
using std::endl;

int s_len, sr_no = 1;

void swap(string& s, int pos1, int pos2) {
  char temp = s[pos1];
  s[pos1] = s[pos2];
  s[pos2] = temp;
}

void permute(string& s, int ind) {
  if (ind == s_len-1) {
    cout << sr_no << ". ";
    ++sr_no;
    cout << s << endl;
  }
  else
    for (int i = ind; i < s_len; i++) {
      swap(s,ind,i);
      permute(s,ind+1);
      swap(s,ind,i);
    }
}

int main(int argc, char* argv[]) {
    string s;
    cout << "Generate permutations for: ";
    cin >> s;
    s_len = s.size();
    permute(s,0);
    return 0;
}
