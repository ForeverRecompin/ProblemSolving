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
#define endl "\n"
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
vector<vi> visited;
int M, N, a, b, t, harryX = 0, harryY = 0, distToGo, dummyDist;
#define OPTIONS 4
int dx[] = {0,  0,  1, -1};
int dy[] = {1, -1,  0,  0};
/////////////////////////////////////////////////////////////////////
struct location
{
  int x, y, dist;
  location(int _x, int _y, int _dist) : x(_x), y(_y), dist(_dist) {}
};

void solveIt() {
  queue<location> q;
  q.push(location(harryX,harryY,t));
  while (!q.empty()) {
    location current = q.front(); q.pop();
    DEBUG DBG(current.x);
    DEBUG DBG(current.y);
    DEBUG DBG(current.dist);
    DEBUG cout << endl;
    distToGo = current.dist - cost[current.x][current.y];

    // Did we find a better path?
    if (current.x == a && current.y == b) {
      DEBUG cout << "Hit termination condition" << endl << endl;
      dummyDist = std::max(distToGo,dummyDist);
    }
    else {
      FOR(j,0,OPTIONS-1) {
        location nextHop(current.x+dx[j],current.y+dy[j],distToGo);
        DEBUG cout << "Testing out different options" << endl;
        DEBUG cout << "From: " << endl;
        DEBUG DBG(current.x);
        DEBUG DBG(current.y);
        DEBUG DBG(current.dist);
        DEBUG cout << "To: " << endl;
        DEBUG DBG(nextHop.x);
        DEBUG DBG(nextHop.y);
        DEBUG DBG(nextHop.dist);
        DEBUG cout << endl;
        if (nextHop.x < 0 || nextHop.x >= M || nextHop.y < 0 || nextHop.y >= N)
          continue;
        if (nextHop.dist < 0 && visited[nextHop.x][nextHop.y] >= nextHop.dist)
          continue;
        visited[nextHop.x][nextHop.y] = nextHop.dist;
        DEBUG cout << "Pushed a new state in the queue" << endl << endl;
        q.push(nextHop);
      }
    }
  }
}

int main(int argc, char *argv[])
{
  ios_base::sync_with_stdio(false);
  cin.tie(0);
  int tc;
  cin >> tc;
  FOR(_tc,0,tc-1) {
    cin >> M >> N;
    cost.assign(M,vi(N));
    visited.assign(M,vi(N));
    FOR(i,0,M-1) {
      FOR(j,0,N-1) {
        cin >> cost[i][j];
        visited[i][j] = -1;
      }
    }
    cin >> a >> b >> t;
    a -= 1;
    b -= 1;
    dummyDist = -1;
    DEBUG cout << "Input seems to be good" << endl;
    DEBUG DBG(a);
    DEBUG DBG(b);
    DEBUG DBG(t);
    solveIt();
    if (dummyDist != -1)
      cout << "YES" << endl << dummyDist << endl;
    else
      cout << "NO" << endl;
  }
  return 0;
}
