#include "CloudNode.hpp"
#include "Formatter.hpp"
using namespace std;

CloudNode::CloudNode(string name, int limit) : server_name(name), used_gb(0), limit_gb(limit)
{
    Formatter::printCtor(server_name);
}

CloudNode::CloudNode(const CloudNode& other) : server_name(other.server_name + "_backup"), used_gb(0), limit_gb(other.limit_gb)
{
    Formatter::printCCtor(server_name);
}

CloudNode& CloudNode::operator=(const CloudNode& other) {
    if (this != &other) {
        int new_used = other.used_gb + 2;
        limit_gb = other.limit_gb;
        used_gb = (new_used > limit_gb) ? limit_gb : new_used;
    }
    Formatter::printAssign(server_name);
    return *this;
}

CloudNode::~CloudNode() {
    Formatter::printDtor(server_name);
}

CloudNode CloudNode::operator+(int n) const {
    CloudNode result = *this; 
    result.limit_gb = limit_gb + n;
    return result;
}

CloudNode CloudNode::operator-(int n) const {
    CloudNode result = *this;
    int new_used = used_gb - n;
    result.used_gb = (new_used < 0) ? 0 : new_used;
    return result;
}

void systemWipe(CloudNode& node) {
    node.used_gb = 0;
    node.limit_gb = 0;
}