package subtask6

import kotlin.collections.ArrayList

class FullBinaryTrees {

        inner class Node{
            var left: Node? = null
            var right: Node? = null
        }

        private fun generateTrees(n: Int): ArrayList<Node>{
            if(n % 2 == 0) return ArrayList()
            if(n == 1) return arrayListOf(Node())
            val result = ArrayList<Node>()
            for(numberOfNodesInSubtree in 1 until n-1 step 2){
                val leftSubTree = generateTrees(numberOfNodesInSubtree)
                val rightSubTree = generateTrees(n - 1 - numberOfNodesInSubtree)
                for(leftSubTreeNode in leftSubTree){
                    for(rightSubTreeNode in rightSubTree){
                        val root = Node()
                        root.left = leftSubTreeNode
                        root.right = rightSubTreeNode
                        result.add(root)
                    }
                }
            }
            return result
        }

    private fun getTreeAsList(n: Node):ArrayList<Int?>{
        val result = ArrayList<Int?>()
        result.add(0)
        val children = ArrayList<Node?>()
        children.add(n.left)
        children.add(n.right)
        while(children.isNotEmpty()){
            val subChildren = ArrayList<Node?>()
            for(child in children){
                if(child == null) result.add(null)
                else{
                    result.add(0)
                    subChildren.add(child.left)
                    subChildren.add(child.right)
                }
            }
            children.clear()
            children.addAll(subChildren)
            subChildren.clear()
        }
        return result
    }

    fun stringForNodeCount(count: Int): String {
        val trees = generateTrees(count)
        val result = ArrayList<ArrayList<Int?>>()
        for(n in trees){
            val treesList = getTreeAsList(n)
            while (treesList.last() == null) treesList.removeAt(treesList.lastIndex)
            result.add(treesList)
        }
        return result.toString()
    }
}