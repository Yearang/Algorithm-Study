import java.util.ArrayList;
import java.util.Scanner;

public class shortest {
    static int v, e, k, m[];
    static boolean visit[];
    static ArrayList<ArrayList<pair<Integer, Integer>>> ar = new <ArrayList<pair<Integer, Integer>>>ArrayList();

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        v = s.nextInt();
        e = s.nextInt();
        k = s.nextInt();
        visit = new boolean[v + 1];
        m = new int[v + 1];
        for (int i = 0; i < v + 1; i++) {
            m[i] = 200001;
        }

        int u, f, w;
        for (int i = 0; i < v + 1; i++) ar.add(new ArrayList<>());

        for (int i = 0; i < e; i++) {
            u = s.nextInt();
            f = s.nextInt();
            w = s.nextInt();

            if(ar.get(u).isEmpty()) {
                ar.get(u).add(new pair<>(f, w));
                if (u == k) {
                    m[f] = w;
                }
            }
            else if (!ar.get(u).isEmpty()) {
                for (int j = 0; j < ar.get(u).size(); j++) {
                    if (ar.get(u).get(j).getto() == f && ar.get(u).get(j).getweight() > w) {
                        ar.get(u).remove(j);
                        ar.get(u).add(new pair<>(f, w));
                        if (u == k) {
                            m[f] = w;
                        }
                        break;
                    }
                }
                ar.get(u).add(new pair<>(f, w));
                if (u == k) {
                    m[f] = w;
                }
            }
        }
        m[k] = 0;
        start = k;
        daik();

        for (int i = 1; i < v + 1; i++) {
            if (m[i] == 200001) {
                System.out.println("INF");
            } else {
                System.out.println(m[i]);
            }
        }


    }

    static int start;

    static public void daik() {
        for (int i = 1; i < v + 1; i++) {
            for (int j = 0; j < ar.get(i).size(); j++) {
                int a = ar.get(i).get(j).getto();
                int w = ar.get(i).get(j).getweight();
                if (w > 0) {
                    if (m[a] > m[i] + w) {
                        m[a] = m[i] + w;
                    }
                }

            }
        }
    }
}

class pair<a, b> {
    private a first;
    private b second;

    public pair(a first, b sceond) {
        this.first = first;
        this.second = sceond;
    }

    public a getto() {
        return first;
    }

    public b getweight() {
        return second;
    }
}


