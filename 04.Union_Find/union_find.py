class UnionFind:
    def __init__(self, n):
        self.rank = [0] * n
        self.parent = list(range(n))

    def find(self, i):
        
        root = self.parent[i]
      
        # Path Compression
        if self.parent[root] != root:
            self.parent[i] = self.find(root)
            return self.parent[i]
      
        return root

    def union(self, x, y):
        xRoot = self.find(x)
        yRoot = self.find(y)

        if xRoot == yRoot:
            return

        # Union by Rank   
        if self.rank[xRoot] < self.rank[yRoot]:
            self.parent[xRoot] = yRoot
        elif self.rank[yRoot] < self.rank[xRoot]:
            self.parent[yRoot] = xRoot
        else:
            self.parent[yRoot] = xRoot
            self.rank[xRoot] += 1

if __name__ == '__main__':
  
    n = 5  # Let there be 5 persons with ids 0, 1, 2, 3, and 4
    dus = UnionFind(n)

    dus.union(0, 2)  # 0 is a friend of 2
    dus.union(4, 2)  # 4 is a friend of 2
    dus.union(3, 1)  # 3 is a friend of 1

    # Check if 4 is a friend of 0
    if dus.find(4) == dus.find(0):
        print('Sim, 4 está no mesmo conj. que 0')
    else:
        print('NÃO, 4 não está no mesmo conj. que 0')

    # Check if 1 is a friend of 0
    if dus.find(1) == dus.find(0):
        print('Sim, 1 está no mesmo conj. que 0')
    else:
        print('NÃO, 1 não está no mesmo conj. que 0')