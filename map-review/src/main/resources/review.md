
评论搜索 mapping

PUT review

```json
{
  "mappings": {
    "properties": {
      "reviewId": {
        "type": "long"
      },
      "userId": {
        "type": "long"
      },
      "reviewContent": {
        "type": "text"
      },
      "reviewCreateTime": {
        "type": "date"
      },
      "reviewUpdateTime": {
        "type": "date"
      }
    }
  }
}
```
