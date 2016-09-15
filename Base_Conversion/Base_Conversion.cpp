#include <iostream>
#include <vector>
#include <string>
#include <algorithm>
#include <cassert>

using std::cout;
using std::cin;
using std::endl;
using std::string;

string convert_base(const string &s, const int &b1, const int &b2) {
  bool neg = s[0] == '-';
  int x = 0;
  for (int i = (neg == true ? 1 : 0); i < s.size(); i++) {
    x *= b1;
    x += isdigit(s[i]) ? s[i] - '0' : s[i] - 'A' + 10;
  }

  string ans;
  while (x) {
    int r = x % b2;
    ans.push_back(r >= 10 ? 'A' + r - 10 : '0' + r);
    x /= b2;
  }

  if (ans.empty())
    ans.push_back('0');

  if (neg)
    ans.push_back('-');

  reverse(ans.begin(),ans.end());
  return ans;
}


int main(int argc, char *argv[])
{
  if (argc >= 2 && argc <= 4) {
    int b1 = std::stoi(argv[2]), b2 = std::stoi(argv[3]);
    string to_convert = argv[1];
    // convert from b1 to b2

    cout << convert_base(to_convert,b1,b2) << endl;
  }
  else
    cout << "You need to give me three arguments: "  << "Number base1 base2. Try again!" << endl;
  //assert(convert_base("2132",5,10) == "292" && "Conversion logic is incorrect. Stopping.");
  return 0;
}
