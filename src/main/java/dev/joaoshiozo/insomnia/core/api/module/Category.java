package dev.joaoshiozo.insomnia.core.api.module;

public enum Category
{
    COMBAT("Combat"),
    EXPLOIT("Exploit"),
    MISC("Misc"),
    MOVEMENT("Movement"),
    RENDER("Render"),
    CHAT("Chat")
    //COMPONENT("Component"),package dev.joaoshiozo.insomnia.core.api.module;
    HIDDEN("Hidden");
    
    public class category {
        
    }
    
	HIDDEN("Hidden");

	private String name;

	Category(String name)
	{
		setName(name);
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}
}
