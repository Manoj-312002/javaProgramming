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

class graph{
	int v;
	vector< list< ipair > >adj;

public:
	graph(int v){ this->v = v; adj.resize(v); }
	void addEdge(int u, int v, int w){
		adj[u].push_back(make_pair(v, w));
		adj[v].push_back(make_pair(u, w));
	}
	void shortestPath(int s);
};
/*
choose the shortest node yet visited
	- add all the nodes connected to it to the priority queue
	- update the distance if not visited
*/

void graph::shortestPath(int src){
	priority_queue< ipair, vector <ipair> , greater<ipair> > pq;
	vector<int> dist(v, INT32_MAX );

	pq.push(make_pair(0, src));
	dist[src] = 0;
	vector<bool> f(v, false);

	while (!pq.empty()){
		dbg(dist);
		// get the smallest node distance
		int u = pq.top().second;
		pq.pop();
		f[u] = true;
		
		// add all the nodes from this node to the priority queue if not visited
		for (auto & i : adj[u] ){
			int v = (i).first;
			int weight = (i).second;
			if (f[v] == false && dist[v] > dist[u] + weight){
				dist[v] = dist[u] + weight;
				pq.push(make_pair(dist[v], v));
			}
		}
	}

	dbg(dist);
}



int main(){
	cout << "Enter number of vertices and edges: "; int V , E; cin >> V >> E;
	graph gr(V); 
	cout << "Enter u , v , w " << endl;
	
	for(int i = 0; i < E ; i++){
		int u , v , w; cin >> u >> v >> w;
		gr.addEdge( u , v , w );
	}
	
	gr.shortestPath(0);
}

