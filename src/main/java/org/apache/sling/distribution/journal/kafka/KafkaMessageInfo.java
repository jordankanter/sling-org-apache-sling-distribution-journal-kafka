/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.apache.sling.distribution.journal.kafka;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.sling.distribution.journal.MessageInfo;

public class KafkaMessageInfo implements MessageInfo {

    private final String topic;
    private final int partition;
    private final long offset;
    private final long createTime;

    public KafkaMessageInfo(ConsumerRecord<String, ?> record) {
        this.topic = record.topic();
        this.partition = record.partition();
        this.offset = record.offset();
        this.createTime = record.timestamp();
    }

    public String getTopic() {
        return topic;
    }

    public int getPartition() {
        return partition;
    }

    public long getOffset() {
        return offset;
    }

    public long getCreateTime() {
        return createTime;
    }

    @Override
    public String toString() {
        return String.format("Topic: %s, Partition: %d, Offset: %d, CreateTime: %d", 
                topic, partition, offset, createTime);
    }
}
