using namespace std;
#include <iostream>
#include <sstream>
#include <cstdio>
#include <cmath>
#include <cstring>
#include <cctype>
#include <string>
#include <vector>
#include <list>
#include <set>
#include <map>
#include <queue>
#include <stack>
#include <algorithm>
#include <functional>
/////////////////////////////////////////////////////////////////////
#define DEBUG if (1)
#define DBG(x) cout << '>' << #x << ':' << x << endl;
#define REP(i,n) for(int i=0;i<(n);i++)
#define FOR(i,a,b) for(int i=(a);i<=(b);i++)
#define FORD(i,a,b) for(int i=(a);i>=(b);i--)
/////////////////////////////////////////////////////////////////////
inline bool EQ(double a, double b) { return fabs(a-b) < 1e-9; }
const int INF = 1000000000;
inline int two(int n) { return 1 << n; }
inline int test(int n, int b) { return (n>>b)&1; }
inline void set_bit(int & n, int b) { n |= two(b); }
inline void unset_bit(int & n, int b) { n &= ~two(b); }
inline int last_bit(int n) { return n & (-n); }
inline int ones(int n) { int res = 0; while(n && ++res) n-=n&(-n); return res; }
template<class T> void chmax(T & a, const T & b) { a = max(a, b); }
template<class T> void chmin(T & a, const T & b) { a = min(a, b); }
/////////////////////////////////////////////////////////////////////
typedef long long ll;
typedef pair<int,int> ii;
typedef vector<int> vi;
typedef vector<ii> vii;
/////////////////////////////////////////////////////////////////////
// Globals
vector<vi> cost;
vector<vector<bool> > visited;
int M, N, a, b, t, harryX = 0, harryY = 0;
#define OPTIONS 4
int dx[] = {0,  0, -1, -1};
int dy[] = {1, -1,  0,  0};
/////////////////////////////////////////////////////////////////////
struct compareBycost {
  bool operator()(ii nodeA, ii nodeB) {
    return cost[nodeA.first][nodeA.second] > cost[nodeB.first][nodeB.second];
  }
};

void diskstra() {
  // Initially, dist for node(0,0) comes from the cost matrix
  priority_queue<ii,vii,compareBycost> pq;
  pq.push(ii(harryX,harryY));
  while (!pq.empty()) {
    cout << "Entered the pq\n";
    ii cur = pq.top(); pq.pop();
    DBG(cur.first);
    DBG(cur.second);
    // Harry finally reached Hermione. Stop!
    if (cur.first == a-1 && cur.second == b-1)
      break;
    // Else, relax!
    FOR(i,0,OPTIONS-1) {
      ii next(cur.first+dx[i],cur.second+dy[i]);
      if (next.first < 0 || next.first >= M || next.second < 0 || next.second >= N || visited[next.first][next.second])
        continue;
      if (cost[cur.first][cur.second] + cost[next.first][next.second]  < cost[next.first][next.second]) {
        visited[next.first][next.second] = true;
        cost[next.first][next.second] = cost[cur.first][cur.second] + cost[next.first][next.second];
        pq.push(next);
      }
    }
  }
}

int main(int argc, char *argv[])
{
  ios_base::sync_with_stdio(false);
  //cin.tie(0);
  int tc;
  cin >> tc;
  FOR(_tc,0,tc-1) {
    cin >> M >> N;
    cost.assign(M,vi(N));
    visited.assign(M,vector<bool>(N));
    FOR(i,0,M-1) {
      FOR(j,0,N-1) {
        cin >> cost[i][j];
        visited[i][j] = false;
      }
    }
    cin >> a >> b >> t;
    DEBUG cout << "Input seems to be good\n";
    DBG(a);
    DBG(b);
    DBG(t);
    //diskstra();
    cout << visited[a-1][b-1] << "\n";
  }
  return 0;
}
