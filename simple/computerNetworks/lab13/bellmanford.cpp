#include <bits/stdc++.h>
using namespace std;
#define fr(i,j) for ( int i=0 ; i<(int)(j) ; i++)
using ll = long long;
#define mkp make_pair
#define ipair pair<int,int>
#define F first
#define S second
#define pb push_back
#define vi vector<int>
#define fast ios::sync_with_stdio(0);cin.tie(0);cout.tie(0);
template<typename A, typename B> ostream& operator<<(ostream &os, const pair<A, B> &p) { return os << '(' << p.first << ", " << p.second << ')'; } template<typename T_container, typename T = typename enable_if<!is_same<T_container, string>::value, typename T_container::value_type>::type> ostream& operator<<(ostream &os, const T_container &v) { os << '{'; string sep; for (const T &x : v) os << sep << x, sep = ", "; return os << '}'; } void dbg_out() { cerr << endl; } template<typename Head, typename... Tail> void dbg_out(Head H, Tail... T) { cerr << ' ' << H; dbg_out(T...); }
#define dbg(...) cerr << "(" << #__VA_ARGS__ << "):", dbg_out(__VA_ARGS__)

/*
Traverse through all the edges relax each time
complexity - E*V
negative edge - ok 
v the iteration changes -> negative cycle present
*/

int main(){
	cout << "Enter number of vertices and edges ";
	int E , V ; cin >> V >> E;

	cout << "Enter start vertext , end vertex and weight : " << endl;
	vector< tuple<int,int,int> > graph(E);
	vector<int> distance(E , INT32_MAX );

	for(int i = 0; i < E ; i++){
		int u , v , w; cin >> u >> v >> w;
		graph[i] = {u,v,w};
	}

	distance[0] = 0;
	for( int i = 0; i < V-1 ; i++ ){
		for( auto ed : graph ){
			int u , v , w ; tie(u,v,w) = ed;
			// updating distance
			distance[v] = min( distance[v] , distance[u] + w );
		}
		dbg(distance);
	}
	
	dbg(distance);
}
