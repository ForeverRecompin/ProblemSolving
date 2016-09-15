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
#define DEBUG if (0)
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
vector<vi> dist;
int M, N, a, b, t, harryX = 0, harryY = 0;
#define OPTIONS 4
int dx[] = {0,  0,  1, -1};
int dy[] = {1, -1,  0,  0};
/////////////////////////////////////////////////////////////////////
struct location
{
  int x, y, dist;
  location(int _x, int _y) : x(_x), y(_y) {}
};

struct compareBycost {
  bool operator()(location A, location B) {
    return cost[A.x][A.y] > cost[B.x][B.y];
  }
};

void solveIt() {
  // Initially, dist for node(0,0) comes from the cost matrix
  dist[harryX][harryY] = cost[harryX][harryY];
  visited[harryX][harryY] = true;

  priority_queue<location,vector<location>,compareBycost> pq;
  pq.push(location(harryX,harryY));

  while (!pq.empty()) {
    DEBUG cout << "Entered the pq" << endl;
    location cur = pq.top(); pq.pop();
    DEBUG DBG(cur.x);
    DEBUG DBG(cur.y);
    // Harry finally reached Hermione. Stop!
    if (cur.x == a && cur.y == b)
      break;
    // Else, go on!
    FOR(i,0,OPTIONS-1) {
      location nextHop(cur.x+dx[i],cur.y+dy[i]);
      DEBUG cout << "Testing out different options" << endl;
      DEBUG cout << "From: " << endl;
      DEBUG DBG(cur.x);
      DEBUG DBG(cur.y);
      DEBUG cout << "To: " << endl;
      DEBUG DBG(nextHop.x);
      DEBUG DBG(nextHop.y);
      DEBUG cout << endl;
      if (nextHop.x < 0 || nextHop.x >= M || nextHop.y < 0 || nextHop.y >= N)
        continue;
      if (visited[nextHop.x][nextHop.y] == true)
        continue;
      // Relaxation
      int relaxDis = dist[cur.x][cur.y] + cost[nextHop.x][nextHop.y];
      DEBUG DBG(dist[nextHop.x][nextHop.y]);
      DEBUG DBG(relaxDis);
      if (dist[nextHop.x][nextHop.y] > relaxDis) {
        DEBUG cout << "Yay, relaxed" << endl;
        dist[nextHop.x][nextHop.y] = relaxDis;
        visited[nextHop.x][nextHop.y] = true;
        pq.push(nextHop);
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
    cost.assign(M,vi(N,0));
    visited.assign(M,vector<bool>(N));
    dist.assign(M,vi(N,INF));
    FOR(i,0,M-1) {
      FOR(j,0,N-1) {
        cin >> cost[i][j];
        visited[i][j] = false;
      }
    }
    cin >> a >> b >> t;
    DEBUG cout << "Input seems to be good\n";
    DEBUG DBG(a);
    DEBUG DBG(b);
    DEBUG DBG(t);
    solveIt();
    int result = dist[a-1][b-1];
    if (result > t) // We went overboard, she died ;(
      cout << "NO" << endl;
    else // Return difference
      cout << "YES" << endl << t-result << endl;
  }
  return 0;
}
