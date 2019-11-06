#include "Node.h"

Node::Node(int d, Node* n)
{
    data = d;
    next = n;
}

Node* Node::getNext()
{
    return next;
}

void Node::setNext(Node* newNext)
{
    next = newNext;
}

int Node::getData()
{
    return data;
}