package aGUI.controller;

import aGUI.view.SampleGUI;

public class SampleAppController {
	private SampleGUI appframe;
	public void start() {
		appframe = new SampleGUI(this);
	}

}
