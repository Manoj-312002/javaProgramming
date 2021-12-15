#include<bits/stdc++.h>
using namespace std;
# define INF 0x3f3f3f3f
#define ipair pair<int,int>

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


void graph::shortestPath(int src){
	priority_queue< ipair, vector <ipair> , greater<ipair> > pq;
	vector<int> dist(v, INF);

	pq.push(make_pair(0, src));
	dist[src] = 0;
	vector<bool> f(v, false);

	while (!pq.empty()){
		int u = pq.top().second;
		pq.pop();
		f[u] = true;

		for (auto & i : adj[u] ){
			int v = (i).first;
			int weight = (i).second;
			if (f[v] == false && dist[v] > dist[u] + weight){
				dist[v] = dist[u] + weight;
				pq.push(make_pair(dist[v], v));
			}
		}
	}

	printf("Vertex Distance from Source\n");
	for (int i = 0; i < v; ++i)
		printf("%d \t\t %d\n", i, dist[i]);
}



int main(){
	cout << "Enter number of vertices : ";
	int ch = 0 , u  ,v , w;
	cin >> v;
	graph gr(v); 

	cout << "Choose an option \n1. Add edge\n2. Dijkstras\n3. Exit";
	cout << endl;

	while( ch != 3 ){
		cin >> ch;
		switch(ch){
			case 1:
				cout << "Enter u and v : " ;
				cin >> u >> v >> w;
				gr.addEdge( u , v , w);
				break;
			case 2:
				cout << "Dijkstras : " << endl << endl;
				gr.shortestPath(0);
				break;
			case 3:
				break;

		}
	}
}

