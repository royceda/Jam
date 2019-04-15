from heapq import heappop, heappush
import gc


class OurHeap:
    """ min heap
    * heap: is the actual heap, heap[1] = index of the smallest element
    * rank: inverse of heap with rank[x]=i iff heap[i]=x
    * n: size of the heap
    :complexity: init O(n log n), len O(1),
                other operations O(log n) in expectation
                and O(n) in worst case, due to the usage of a dictionary
    """
    def __init__(self, items):
        self.heap = [None]  # index 0 will be ignored
        self.rank = {}
        for x in items:
            self.push(x)

    def __len__(self):
        return len(self.heap) - 1

    def push(self, x):
        """Insert new element x in the heap.
           Assumption: x is not already in the heap"""
        assert x not in self.rank
        i = len(self.heap)
        self.heap.append(x)    # add a new leaf
        self.rank[x] = i
        self.up(i)             # maintain heap order

    def pop(self):
        """Remove and return smallest element"""
        root = self.heap[1]
        del self.rank[root]
        x = self.heap.pop()    # remove last leaf
        if self:               # if heap is not empty
            self.heap[1] = x   # put last leaf to root
            self.rank[x] = 1
            self.down(1)       # maintain heap order
        return root
    # snip}

    # snip{ our_heap_up_down
    def up(self, i):
        """The value of heap[i] has decreased. Maintain heap invariant."""
        x = self.heap[i]
        while i > 1 and x < self.heap[i // 2]:
            self.heap[i] = self.heap[i // 2]
            self.rank[self.heap[i // 2]] = i
            i //= 2
        self.heap[i] = x       # insertion index found
        self.rank[x] = i

    def down(self, i):
        """the value of heap[i] has increased. Maintain heap invariant."""
        x = self.heap[i]
        n = len(self.heap)
        while True:
            left = 2 * i       # climb down the tree
            right = left + 1
            if (right < n and self.heap[right] < x and
                    self.heap[right] < self.heap[left]):
                self.heap[i] = self.heap[right]
                self.rank[self.heap[right]] = i   # go back up right child
                i = right
            elif left < n and self.heap[left] < x:
                self.heap[i] = self.heap[left]
                self.rank[self.heap[left]] = i    # go back up left child
                i = left
            else:
                self.heap[i] = x   # insertion index found
                self.rank[x] = i
                return

    def update(self, old, new):
        """Replace an element in the heap
        """
        i = self.rank[old]     # change value at index i
        del self.rank[old]
        self.heap[i] = new
        self.rank[new] = i
        if old < new:          # maintain heap order
            self.down(i)
        else:
            self.up(i)


def dijkstra(n, source=0, target=None):

    p = {
        'S' : n,
        'E' : 1
    } 
    #prepare graph
    graph = []
    for i in range(n**2):
        l = []
        #if i%n - 1 >= 0 :
        #    l.append(i-1)
        if i%n + 1 < n:
            l.append(i+1)
        if i+n < n**2:
            l.append(i+n)
        #if i-n >= 0:
        #    l.append(i-n)
        graph.append(l)

    #remove edges
    node = 0
    for i in no_path:
        next_node = node + p[i]
        if len(graph[next_node]) > 0 and node in graph[next_node]:
            graph[next_node].remove(node)
        if len(graph[node]) > 0 and next_node in graph[node]:
            graph[node].remove(next_node)  
        node = next_node 


    #weights
    weight = [[100 for v in graph] for u in graph]
    for i in range(len(graph)):
        for j in graph[i]:
            weight[i][j] = 1

    n = len(graph)
    assert all(weight[u][v] >= 0 for u in range(n) for v in graph[u])
    prec = [None] * n
    dist = [float('inf')] * n
    dist[source] = 0
    heap = OurHeap([(dist[node], node) for node in range(n)])
    while heap:
        dist_node, node = heap.pop()       # Closest node from source
        if node == target:
            break
        for neighbor in graph[node]:
            old = dist[neighbor]
            new = dist_node + weight[node][neighbor]
            if new < old:
                dist[neighbor] = new
                prec[neighbor] = node
                heap.update((old, neighbor), (new, neighbor))
    return dist, prec


def grid(n, no_path):
    #n = 3
    s = 0
    t = n**2-1

    p = {
        'S' : n,
        'E' : 1
    }    

    dist , prec = dijkstra(n, 0, n**2-1)
    gc.collect()

    path = []
    path.append(s)
    
    prec.append(n**2-1)
    #print(prec)
    i = prec[len(prec)-1]
    while i != None or i >= 0:
        #print(i)
        if i != None:
            path.append(i)
        i = prec[i]
    path = path[::-1]
    #print(path)

    res = []

    for i in range(len(path)):
        if i<len(path)-1:
            if path[i+1] == path[i]+1:
                res.append('E')
            if path[i+1] == path[i]+n:
                res.append('S')
            if path[i+1] == path[i]-n:
                res.append('N')
            if path[i+1] == path[i]-1:
                res.append('W')
    return "".join(res)


if __name__ == "__main__":
    t = int(input()) 
    for i in range(1, t + 1):
      n = int(input())
      no_path = str(raw_input())
      print("Case #{}: {}".format(i, grid(n, no_path)))
    pass
