package com.bnade.wow.client.model;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * wowhead返回的物品信息xml的根节点
 */
@XmlRootElement(name = "wowhead")
public class XWowHead {

	private XItem item;

	public XItem getItem() {
		return item;
	}

	public void setItem(XItem item) {
		this.item = item;
	}

	@Override
	public String toString() {
		return "XWowHead{" +
				"item=" + item +
				'}';
	}

}
