/**
* BinaryTreeNode generic class with the attributes of the parameterized datatype
* and functions 
*
*@author Shaun
*@version 1.0 28/02/2022
*/

public class BinaryTreeNode<dataType>
{
   dataType data;
   BinaryTreeNode<dataType> left;
   BinaryTreeNode<dataType> right;
   int height;

   /**
   * BinaryTreeNode constructor to inintialize the attributes of a BinaryTreeNode
   *
   * @param d the data type
   * @param l is the left BinaryTreeNode
   * @param r is the right BinaryTreeNode
   */
      
   public BinaryTreeNode(dataType d, BinaryTreeNode<dataType> l, BinaryTreeNode<dataType> r)
   {
      data = d;
      left = l;
      right = r;
      height = 0;
   }
   
   /**
   * Get method to return the left binary tree node
   * 
   * @return the left BinaryTreeNode
   */

   BinaryTreeNode<dataType> getLeft() { return left; }
   
   /**
   * Get method to return the right BinaryTreeNode
   * 
   * @return the right BinaryTreeNode
   */

   BinaryTreeNode<dataType> getRight() { return right; }
   
   /**
   * Returns the data associated with this BinaryTreeNode
   *
   * @return the data of the datatype attribute of the BinaryTreeNode 
   */

   public dataType getData()
   {
      return data;
   }
}
