package xmu.mystore.goodsmgt.wcf.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


/**
*@author created by 王崇菲
*@date 2017年5月31日--下午1:44:14
*/
@Entity
@Table(name="142492_brand")
public class Brand {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(nullable = false)
	private Long brand_id;		 //品牌id
	@Column
	private String name;		 //品牌名称
	@Column
	private String website;		 //品牌网址
	@Column
	private String description;	 //品牌描述
	@Column
	private Integer type;		 //品牌状态（目前表示是否在前台显示）
	
	public Brand()
	{
		
	}
	
	public Brand(String name,String websitr,String description,Integer type)
	{
		this.name=name;
		this.website=websitr;
		this.description=description;
		this.type=type;
	}
	public Long getBrand_id() {
		return brand_id;
	}
	public void setBrand_id(Long brand_id) {
		this.brand_id = brand_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getWebsite() {
		return website;
	}
	public void setWebsite(String website) {
		this.website = website;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
}
