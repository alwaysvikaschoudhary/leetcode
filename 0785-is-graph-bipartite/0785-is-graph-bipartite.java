class Solution {
    // static class Edge(
    //     int src;
    //     int des;

    //     Edge(int s, int d) {
    //         this.src = s;
    //         this.des = d;
    //     }
    // )

    // public void createGraph(int[][] graph) {
    //     for(int i=0; i<graph.length; i++) {
    //         graph
    //     }
    // }

    public boolean isBipartite(int[][] graph) {
        int color[] = new int[graph.length];

        for(int i=0; i<graph.length; i++) {
            color[i] = -1;
        }

        Queue <Integer> q = new LinkedList<>();

        for(int i=0; i<graph.length; i++) {
            if(color[i] == -1) { //BFS
                q.add(i); //adding it to queue
                color[i] = 0; //yellow color

                while(!q.isEmpty()) {
                    int curr = q.remove();

                    for(int j=0; j<graph[curr].length; j++){ //adding ever neighbour of the current to queue
                        int d = graph[curr][j]; //dest
                        
                        //case 1 have no color
                        if(color[d] == -1){ 
                            int nextColor = color[curr] == 0 ? 1 : 0; //if curr col = 0 then nextCol = 1 other wise 0;
                            color[d] = nextColor;
                            q.add(d);
                        }

                        //case 3 (if neighbour have same color)
                        else if(color[d] == color[curr]){
                            return false; //Not bipartite
                        }
                        //case 2 continue so do nothing
                    }
                }
            }
        }

        return true;
    }
}