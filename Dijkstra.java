/*
A - (B,2),(C,1)
B - (C,1)
C - (E,2),(D,8),(A,9)
D - (A,3)
E - (D,3)
*/
package DSA.Assignment_2;

import java.net.StandardSocketOptions;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;
import static java.lang.Character.toUpperCase;

class Node implements Comparator<Node> {
    private int v;
    private int weight;

    Node(int _v, int _w) {
        v = _v;
        weight = _w;
    }

    Node() {
    }

    int getV() {
        return v;
    }

    int getWeight() {
        return weight;
    }

    @Override
    public int compare(Node node1, Node node2) {
        if (node1.weight < node2.weight)
            return -1;
        if (node1.weight > node2.weight)
            return 1;
        return 0;
    }
}

class Dijkstra {
    void shortestPath(int s, ArrayList<ArrayList<Node>> adj, int N, int vendorNodes[]) {
        int dist[] = new int[N];

        for (int i = 0; i < N; i++) dist[i] = 100000000;
        dist[s] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<Node>(N, new Node());
        pq.add(new Node(s, 0));

        while (pq.size() > 0) {
            Node node = pq.poll();
            for (Node it : adj.get(node.getV())) {

                if (dist[node.getV()] + it.getWeight() < dist[it.getV()]) {
//                    System.out.print(node.getV());
                    dist[it.getV()] = dist[node.getV()] + it.getWeight();
                    pq.add(new Node(it.getV(), dist[it.getV()]));
//                    System.out.print(" -> " + it.getV());
//                    System.out.println(" Total Weight : " + dist[it.getV()]);
                }
            }
        }
//        System.out.println("The distances from source "+(char)(s+65) +" are : ");
//        for (int i = 0; i < N; i++) {
//            System.out.print( dist[i] + " ");
//        }

        int shortest = 100000000, temp = 0;
        for (int i : vendorNodes) {
            if (dist[i] < shortest) {
                shortest = dist[i];
                temp = i;
            }
        }
        System.out.println("\nThe shortest route is " + (char) (s + 65) + " to " + (char) (temp + 65) + " : Distance = " + shortest);
    }

    public static void main(String args[]) {
        ReadInput r = new ReadInput();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the no. of Nodes");
        int n = sc.nextInt();

        ArrayList<ArrayList<Node>> adj = new ArrayList<ArrayList<Node>>();

        System.out.println("\nEnter the Source Node : ");
        int s = toUpperCase(sc.next().charAt(0)) - 65;

        System.out.println("\nEnter the no of Vendor Nodes : ");
        int nV = sc.nextInt();
        int vendorNodes[] = new int[nV];

        System.out.println("\nEnter the Vendor Node : ");
        for (int i = 0; i < nV; i++)
            vendorNodes[i] = toUpperCase(sc.next().charAt(0)) - 65;

        char graph[] = r.getGraph();

        for (int i = 0; i < n; i++)
            adj.add(new ArrayList<Node>());

        for(int i = 0; i < graph.length; i += 3)
            adj.get(graph[i] - 65).add(new Node(graph[i+1] - 65, Character.getNumericValue(graph[i+2])));
//            System.out.println((graph[i] - 65)+" "+(graph[i+1] - 65)+" "+Character.getNumericValue(graph[i+2]));


        /*adj.get(0).add(new Node(1, 2));
        adj.get(0).add(new Node(2, 1));

        adj.get(1).add(new Node(2, 1));

        adj.get(2).add(new Node(4, 2));
        adj.get(2).add(new Node(3, 8));
        adj.get(2).add(new Node(0, 9));

        adj.get(3).add(new Node(0, 3));

        adj.get(4).add(new Node(3, 3));*/

        Dijkstra obj = new Dijkstra();
        obj.shortestPath(s, adj, n, vendorNodes);

        sc.close();
    }
}