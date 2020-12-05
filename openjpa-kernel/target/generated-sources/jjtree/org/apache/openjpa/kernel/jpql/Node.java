/* Generated By:JJTree: Do not edit this line. Node.java Version 4.3 */
/* JavaCCOptions:MULTI=false,NODE_USES_PARSER=true,VISITOR=false,TRACK_TOKENS=false,NODE_PREFIX=JPQL,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
package org.apache.openjpa.kernel.jpql;

/* All AST nodes must implement this interface.  It provides basic
   machinery for constructing the parent and child relationships
   between nodes. */

public
interface Node {

  /** This method is called after the node has been made the current
    node.  It indicates that child nodes can now be added to it. */
  public void jjtOpen();

  /** This method is called after all the child nodes have been
    added. */
  public void jjtClose();

  /** This pair of methods are used to inform the node of its
    parent. */
  public void jjtSetParent(Node n);
  public Node jjtGetParent();

  /** This method tells the node to add its argument to the node's
    list of children.  */
  public void jjtAddChild(Node n, int i);

  /** This method returns a child node.  The children are numbered
     from zero, left to right. */
  public Node jjtGetChild(int i);

  /** Return the number of children the node has. */
  public int jjtGetNumChildren();
}
/* JavaCC - OriginalChecksum=121af81ccc453671e4d85196ff31362e (do not edit this line) */
