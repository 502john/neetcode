# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

"""
We need a strategy to recurse through so the whole tree is checked for.


dfs(a, b)
that goes through the whole thing. 

dfs(a,b) has access to a.left, a.right AND b.left and b.right.

what dfs(a,b) should do is return some kind of result that can go through the whole tree. 

The strategy changes if we return true or false all the way up. 
Ideally we want to return one violating case the immediately halts the program.

The base case is what? 

When both children are the same or both are null.

Wait we already check for both children beign the same, if both are null thats a good base case. 

Then all we need to do is the three checks
1) Check the current children in front of us. If those values are good continue.

2) Check the left tree

3) Check the right tree



"""


class Solution:
    def isSameTree(self, p: Optional[TreeNode], q: Optional[TreeNode]) -> bool:

        # Base Case
        if p is None and q is None:
            return True

        # Nullity Check
        if (p is None and q is not None ) or (p is not None and q is None):
            return False

        # Sameness Check
        if p.val != q.val:
            return False

        return self.isSameTree(p.left, q.left) and self.isSameTree(p.right, q.right)





        